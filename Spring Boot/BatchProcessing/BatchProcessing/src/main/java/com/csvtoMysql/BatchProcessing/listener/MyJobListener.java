package com.csvtoMysql.BatchProcessing.listener;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

public class MyJobListener implements JobExecutionListener{
	@Override public void beforeJob(JobExecution je) {
		System.out.println("Started at "+je.getStartTime()); 
		System.out.println("Status: "+je.getStatus()); 
		} 
	@Override 
	public void afterJob(JobExecution je) { 
		System.out.println("End at "+je.getEndTime()); 
		System.out.println("Status: "+je.getStatus()); 
		} }