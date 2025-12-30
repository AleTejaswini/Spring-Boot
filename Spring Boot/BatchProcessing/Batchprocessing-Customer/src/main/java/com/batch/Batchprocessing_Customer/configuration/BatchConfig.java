package com.batch.Batchprocessing_Customer.configuration;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.partition.PartitionHandler;
import org.springframework.batch.core.partition.support.Partitioner;
import org.springframework.batch.core.partition.support.TaskExecutorPartitionHandler;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.transaction.PlatformTransactionManager;

import com.batch.Batchprocessing_Customer.entity.Customer;
import com.batch.Batchprocessing_Customer.partitioning.ColumnrangePartitioning;
import com.batch.Batchprocessing_Customer.repository.CustomerRepository;

import com.batch.Batchprocessing_Customer.processor.CustomerProcessor;
@Configuration
public class BatchConfig {

    @Autowired
    private CustomerRepository customerRepo;

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private PlatformTransactionManager transactionManager;


    @Bean
    @StepScope
    public FlatFileItemReader<Customer> reader(
            @Value("#{jobParameters['filePath']}") String filePath,
            @Value("#{stepExecutionContext['start']}") Integer start,
            @Value("#{stepExecutionContext['end']}") Integer end) {

        FlatFileItemReader<Customer> reader = new FlatFileItemReader<>();

        reader.setResource(new FileSystemResource(filePath));

        // IMPORTANT:
        // start = actual CSV line number
        // so skip (start - 1)
        reader.setLinesToSkip(start - 1);

        reader.setLineMapper(new DefaultLineMapper<>() {{
            setLineTokenizer(new DelimitedLineTokenizer() {{
                setDelimiter(",");
                setNames("id", "firstname", "lastname", "country", "email", "dob");
            }});
            setFieldSetMapper(new BeanWrapperFieldSetMapper<>() {{
                setTargetType(Customer.class);
            }});
        }});

        // Read only assigned range
        reader.setMaxItemCount(end - start + 1);

        return reader;
    }


    
    @Bean
    public ItemProcessor<Customer, Customer> processor() {
        return new CustomerProcessor();
    }
    @Bean
    public RepositoryItemWriter<Customer> writer() {
        RepositoryItemWriter<Customer> writer = new RepositoryItemWriter<>();
        writer.setRepository(customerRepo);
        writer.setMethodName("save");
        return writer;
    }
    
    @Bean
    public Step slaveStep() {
        return new StepBuilder("slaveStep", jobRepository)
                .<Customer, Customer>chunk(50, transactionManager)
                .reader(reader(null, null, null))
                .processor(processor())
                .writer(writer())
                .faultTolerant()
                .skip(IllegalArgumentException.class)
                .skipLimit(10)
                .build();
    }

    @Bean
    public Step masterStep() {
        return new StepBuilder("masterStep", jobRepository)
                .partitioner("slaveStep", partitioner())
                .step(slaveStep())
                .gridSize(5)
                .taskExecutor(taskExecutor())
                .build();
    }

    
    @Bean
    public Partitioner partitioner() {
        return new ColumnrangePartitioning(); // must set startLine & endLine
    }
   
    @Bean
    public TaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(5);
        executor.setMaxPoolSize(5);
        executor.setQueueCapacity(10);
        executor.initialize();
        return executor;
    }

   

    @Bean
    public Job job() {
        return new JobBuilder("customerJob", jobRepository)
                .incrementer(new RunIdIncrementer())
                .start(masterStep())
                .build();
    }


	
}
