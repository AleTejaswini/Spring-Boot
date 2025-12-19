package com.csvtoMysql.BatchProcessing.configuration;

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

import com.csvtoMysql.BatchProcessing.entity.Employee;
import com.csvtoMysql.BatchProcessing.listener.MyJobListener;
import com.csvtoMysql.BatchProcessing.processor.EmployeeProcessor;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

	// read object class
	@Bean
	public FlatFileItemReader<Employee> reader() {
		FlatFileItemReader<Employee> reader = new FlatFileItemReader<Employee>();
		reader.setResource(new ClassPathResource("employee.csv"));
		
		reader.setLineMapper(new DefaultLineMapper<>() {{
			setLineTokenizer(new DelimitedLineTokenizer() {{
				setDelimiter(",");
				setNames("id","empname","age","address","jobType");

			}});
			
			setFieldSetMapper(new BeanWrapperFieldSetMapper<>(){{
				setTargetType(Employee.class);
			}});
		}});
			return reader;
	}

	// processor class object
	 @Bean
	 public ItemProcessor<Employee, Employee> processor() {
	       return new EmployeeProcessor();
	    }

	@Autowired
	private DataSource datsource;
	
	// writer class object
	@Bean
	public JdbcBatchItemWriter<Employee> writer() {
		JdbcBatchItemWriter<Employee> writer = new JdbcBatchItemWriter();
		writer.setDataSource(datsource);
		writer.setSql("Insert into employee(id,empname,age,address,salary) values (:id,:empname,:age,:address,:salary)");
		writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());
		return writer;
	}
	
	
	
	
	// listener class object
	@Bean
	public JobExecutionListener listener() {
		return new MyJobListener( );
	}

	// autowire Step Builder factory
	@Autowired
	private StepBuilderFactory sf;

	// step object
	@Bean
	public Step stepA() {
		return sf.get("stepA")
				.<Employee,Employee>chunk(2)
				.reader(reader())
				.processor(processor())
				.writer(writer())
				.build();
	}

	// autowire job builder factory
	@Autowired
	private JobBuilderFactory jf;

	// step object
	@Bean
	public Job jobA() {
		return jf.get("jobA")
				.incrementer(new RunIdIncrementer())
				.listener(listener())
				.start(stepA())
				.build();
	}
}      