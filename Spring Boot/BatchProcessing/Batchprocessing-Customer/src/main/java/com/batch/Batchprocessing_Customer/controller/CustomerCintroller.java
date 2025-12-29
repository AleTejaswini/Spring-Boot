package com.batch.Batchprocessing_Customer.controller;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customerjob")
public class CustomerCintroller {
	@Autowired
	private JobLauncher joblauncher;
	@Autowired
	private Job job;
	
	@PostMapping("/importcustomers")
	public void importcsvtodb() throws Exception{
		JobParameters jobparameters = new JobParametersBuilder()
				.addLong("runid", System.currentTimeMillis())
				.toJobParameters();
		joblauncher.run(job, jobparameters);
	}
}
