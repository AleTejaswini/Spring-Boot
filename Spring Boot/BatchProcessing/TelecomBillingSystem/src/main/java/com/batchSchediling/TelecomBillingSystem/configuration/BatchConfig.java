package com.batchSchediling.TelecomBillingSystem.configuration;

import java.util.Date;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.PlatformTransactionManager;

import com.batchSchediling.TelecomBillingSystem.entity.CallsSummary;
import com.batchSchediling.TelecomBillingSystem.processor.CallsProcessor;
import com.batchSchediling.TelecomBillingSystem.writer.CallsWriter;

@Configuration
@EnableBatchProcessing
public class BatchConfig {
	@Bean
	public FlatFileItemReader<CallsSummary> reader(){
		FlatFileItemReader<CallsSummary> reader = new FlatFileItemReader<>();
		reader.setResource(new ClassPathResource("calldetails.csv"));
		 reader.setLinesToSkip(1);

		reader.setLineMapper(new DefaultLineMapper<>() {{
			setLineTokenizer(new DelimitedLineTokenizer() {{
				setDelimiter(",");
				setNames(
					    "mobilenum",
					    "call_type",
					    "total_duration",
					    "call_date"
					);


			}});
			setFieldSetMapper(new BeanWrapperFieldSetMapper<>() {{
				setTargetType(CallsSummary.class);
			}});
			
		}});
		return reader;
	}
	
	// processor
	@Bean
	public ItemProcessor<CallsSummary,CallsSummary> processor() {
		return new CallsProcessor();
	}
	
	//writer
	@Bean
	public ItemWriter<CallsSummary> writer(){
		return new CallsWriter();
	}
	
	//step
	@Bean
	public Step step(JobRepository jobrepository, PlatformTransactionManager tx) {
	return new StepBuilder("step",jobrepository)
			.<CallsSummary,CallsSummary>chunk(2,tx)
			.reader(reader())
			.processor(processor())
			.writer(writer())
			.build();
	
}
	
	// job
	@Bean
	public Job job(JobRepository jobrepository ,Step step) {
		return new JobBuilder("job",jobrepository)
//				.incrementer(new RunIdIncrementer())
				.start(step)
				.build();
				
	}
}