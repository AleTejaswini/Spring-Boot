package com.batchSchediling.TelecomBillingSystem.configuration;

import java.beans.PropertyEditorSupport;
import java.time.LocalDate;
import java.util.Date;
import java.util.Map;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.PlatformTransactionManager;

import com.batchSchediling.TelecomBillingSystem.entity.CallsSummary;
import com.batchSchediling.TelecomBillingSystem.processor.CallsProcessor;
import com.batchSchediling.TelecomBillingSystem.writer.CallsWriter;

import com.batchSchediling.TelecomBillingSystem.listener.MyJobListener;

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
				setNames("id",
					    "mobilenum",
					    "call_type",
					    "total_duration",
					    "call_date"
					);


			}});
			setFieldSetMapper(new BeanWrapperFieldSetMapper<>() {{
			    setTargetType(CallsSummary.class);
			    setCustomEditors(Map.of(
			        LocalDate.class, new PropertyEditorSupport() {
			            @Override
			            public void setAsText(String text) {
			                setValue(LocalDate.parse(text));
			            }
			        }
			    ));
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
//	listener
	@Bean
	public JobExecutionListener listener() {
		return new MyJobListener();
	}
	@Autowired
	private StepBuilderFactory sf;
	@Bean
	public Step step() {
		return sf.get("step")
				.<CallsSummary,CallsSummary>chunk(2)
				.reader(reader())
				.processor(processor())
				.writer(writer())
				.build();
	}
	
	@Autowired
	private JobBuilderFactory jf;
	
	@Bean
	public Job job() {
		return jf.get("job")
				.incrementer(new RunIdIncrementer())
				.listener(listener())
				.start(step())
				.build();
	}
}