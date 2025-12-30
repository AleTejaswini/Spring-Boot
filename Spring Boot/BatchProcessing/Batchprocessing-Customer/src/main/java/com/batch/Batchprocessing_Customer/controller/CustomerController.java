package com.batch.Batchprocessing_Customer.controller;

import java.io.File;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/customerjob")
public class CustomerController {

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private Job customerJob;

    @PostMapping("/importcustomers")
    public String importCsvToDb(@RequestParam("file") MultipartFile multipartFile) throws Exception {

        
        File tempFile = File.createTempFile("customers-", ".csv");
        multipartFile.transferTo(tempFile);


//    	String originalfile = multipartFile.getOriginalFilename();
//    	File filetoimport = new File(originalfile);
       
        JobParameters jobParameters = new JobParametersBuilder()
                .addString("filePath", tempFile.getAbsolutePath()) // IMPORTANT
                .addLong("runId", System.currentTimeMillis())
                .toJobParameters();

       
        jobLauncher.run(customerJob, jobParameters);

        return "Customer import job started successfully";
    }
}
