package com.schedulerconfig.SchedulerDB.service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.concurrent.ScheduledFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Service;

import com.schedulerconfig.SchedulerDB.repository.SchedulerConfigRepository;

@Service
public class DynamicSchedulerService {
	
	private final TaskScheduler  taskscheduler;
	
	@Autowired
	private SchedulerConfigRepository repo;
	
	private ScheduledFuture<?> scheduledTask;
	
	
	public DynamicSchedulerService(TaskScheduler taskscheduler) {
		super();
		this.taskscheduler = taskscheduler;
	}

	public void startTask(int id) {
		long interval = repo.findById(id).get().getInterval();
		scheduledTask = taskscheduler
				.scheduleAtFixedRate(()->run(id), Duration.ofMillis(interval));
	}
	
	public void stopTask(int id) {
		if(scheduledTask !=null) {
			scheduledTask.cancel(false);
		}
	}
	
	public void reStart(int id) {
		stopTask(id);
		startTask(id);
	}
	
	
	public void run(int id) {
		System.out.println( "Task Started with id  :" +id +", at "+LocalTime.now() );
	}

	
	// Crontrigger
	public void startCornTask(int id) {
		String corn = repo.findById(id).get().getCron();
		
		CronTrigger trigger = new CronTrigger(corn);
		scheduledTask = taskscheduler
				.schedule(()->run(id), trigger);
		
	}
}
