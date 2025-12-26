package com.batchScheduling.CompanyDetail.configuration;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SchedulerConfig {
	@Autowired
	private JobLauncher joblauncher;

	@Autowired
	private Job job;
	
	@Scheduled(cron ="*/10 * * * * *")
	public void runjob() throws Exception{
		
		JobParameters params = new JobParametersBuilder()
				.addLong("runId", System.currentTimeMillis())
				.toJobParameters();
		
		joblauncher.run(job, params);
		
	}
}
