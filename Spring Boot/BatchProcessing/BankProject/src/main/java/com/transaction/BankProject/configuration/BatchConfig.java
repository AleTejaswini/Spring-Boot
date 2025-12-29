package com.transaction.BankProject.configuration;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemWriter;
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

import com.transaction.BankProject.entity.Transactions;
import com.transaction.BankProject.listener.MyJobListener;
import com.transaction.BankProject.processor.TransactionProcessor;
import com.transaction.BankProject.writer.TransactionWriter;
@Configuration
@EnableBatchProcessing
public class BatchConfig {

	// read object
	@Bean
	public FlatFileItemReader<Transactions> reader() {
		
		FlatFileItemReader<Transactions> reader= new FlatFileItemReader<>();
		reader.setResource(new ClassPathResource("details.csv"));
		 reader.setLinesToSkip(1);
		reader.setLineMapper(new DefaultLineMapper<>() {{
			setLineTokenizer(new DelimitedLineTokenizer() {{
				setDelimiter(",");
				setNames("id","AccountNo","date","type","amount","status");
			}});
			
			setFieldSetMapper(new BeanWrapperFieldSetMapper<>() {{
				setTargetType(Transactions.class);
			}});
		}});
		return reader;
	}
	
	// processor object
	@Bean
	public ItemProcessor<Transactions,Transactions> processor() {
		return new TransactionProcessor();
	}
	
	
	//writer object class
//	@Autowired
//	private TransactionWriter writer;
	@Bean
	public ItemWriter<Transactions> writer(){
		return new TransactionWriter();
	
	}
	
	//listener class
	@Bean
	public JobExecutionListener listener() {
		return new MyJobListener();
	}
	@Autowired
	private StepBuilderFactory sf;
	
	
	@Bean
	public Step step() {
		return sf.get("step")
				.<Transactions,Transactions>chunk(2)
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
