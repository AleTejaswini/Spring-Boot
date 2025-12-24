package com.transaction.BankProject.configuration;

import java.time.LocalDate;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SchedulerConfig {

	
	@Autowired
	private JobLauncher joblauncher;
	@Autowired
	private Job job;
	
	@Scheduled(cron = "*/30 * * * * *")
	public void runJob() throws Exception {
		 
//		 System.out.println("Scheduler Triggered at: " + new java.util.Date());
//
//		 JobParameters jobparameters = new JobParametersBuilder()
//					.addLong("time", System.currentTimeMillis())
//					.toJobParameters();
//			
//			joblauncher.run(job, jobparameters);
//			System.out.println("Job execution done");
//	       
		
		try {
            JobParameters params = new JobParametersBuilder()
                    
                    .addLong("runTime", System.currentTimeMillis())
                    .toJobParameters();

            joblauncher.run(job, params);

            System.out.println("Batch job triggered successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	          
	
}
