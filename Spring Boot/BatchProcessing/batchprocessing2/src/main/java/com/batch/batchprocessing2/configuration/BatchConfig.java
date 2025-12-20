package com.batch.batchprocessing2.configuration;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.batch.batchprocessing2.entity.User;
import com.batch.batchprocessing2.listener.MyJobListener;
import com.batch.batchprocessing2.processor.UserProcessor;
@Configuration
@EnableBatchProcessing
public class BatchConfig {

	//read object class
	@Bean
	public FlatFileItemReader<User> reader(){
	
		FlatFileItemReader<User> reader = new FlatFileItemReader<>();
		reader.setResource(new ClassPathResource("user.csv"));
		reader.setLineMapper(new DefaultLineMapper<>() {{
			setLineTokenizer(new DelimitedLineTokenizer() {{
				setDelimiter(",");
				setNames("id","username","email","status");
			}});
		
			setFieldSetMapper(new BeanWrapperFieldSetMapper<>() {{
				setTargetType(User.class);
			}});
		}});
		
		return reader;
	}
	
// 	processor object class
	@Bean
	public ItemProcessor<User,User> processor(){
		return new UserProcessor();
	}
	@Autowired
	private DataSource datasource;
	
	// write object class
	@Bean
	public JdbcBatchItemWriter<User> writer(){
		JdbcBatchItemWriter<User> writer = new JdbcBatchItemWriter<>();
		writer.setDataSource(datasource);
		writer.setSql("insert into user (id,username,email,status) values(:id,:username,:email,:status)");
		writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());
		return writer;
	}
	
	//listener class object
	@Bean
	public JobExecutionListener listener() {
		return new  MyJobListener();
	}
	
	// autowired step builder factory
	@Autowired
	private StepBuilderFactory sf;
	
	//step object
	@Bean
	public Step step() {
		return sf.get("step")
				.<User,User>chunk(2)
				.reader(reader())
				.processor(processor())
				.writer(writer())
				.build();
	}
	
	//autowire job buider factory
	@Autowired
	private JobBuilderFactory jf;
	
	//job object
	@Bean
	public Job job() {
		return jf.get("job")
				.incrementer(new RunIdIncrementer())
				.listener(listener())
				.start(step())
				.build();
	
		
		
		
	}
}
