package com.batchScheduling.CompanyDetail.configuration;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.PlatformTransactionManager;

import com.batchScheduling.CompanyDetail.entity.UserDetails;
import com.batchScheduling.CompanyDetail.processor.UserProcessor;
import com.batchScheduling.CompanyDetail.writer.UserWriter;
@Configuration
@EnableBatchProcessing
public class BatchConfig {

	//read class
	@Bean
	public FlatFileItemReader<UserDetails> reader(){
		FlatFileItemReader<UserDetails> reader = new FlatFileItemReader<UserDetails>();
		reader.setResource(new ClassPathResource("userdetails.csv"));
		reader.setLinesToSkip(1);
		reader.setLineMapper(new DefaultLineMapper<>() {{
			setLineTokenizer(new DelimitedLineTokenizer() {{
				setDelimiter(",");
				setNames("UserId","loginDate","loginTime");
			}});
			setFieldSetMapper(new BeanWrapperFieldSetMapper<>() {{
				setTargetType(UserDetails.class);
			}});
		}});
		
		return reader;
		
	}
	
	//processor class
	@Bean
	public ItemProcessor<UserDetails,UserDetails> processor(){
		return new UserProcessor();
	}
	
//	writer class
	@Bean
	public ItemWriter<UserDetails> writer(){
		return new UserWriter();
	}
	
	
//   step
	@Bean
	public Step step(JobRepository jobrepo,
			PlatformTransactionManager tx,
			ItemReader<UserDetails> reader,
			ItemProcessor<UserDetails, UserDetails> processor,
			ItemWriter<UserDetails> writer) {
				return new StepBuilder("step", jobrepo)
						.<UserDetails,UserDetails>chunk(2,tx)
						.reader(reader)
						.processor(processor)
						.writer(writer)
						.build();
		}
	
	
	@Bean
	public Job job(JobRepository jobrepo,Step step) {
		return new  JobBuilder("job", jobrepo)
				.incrementer(new RunIdIncrementer())
				.start(step)
				.build();
				
		
	}
	
}
