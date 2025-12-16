package com.dynamicscheduler.Scheduler;


import java.util.concurrent.ScheduledFuture;

import org.springframework.scheduling.TaskScheduler;
import org.springframework.stereotype.Service;

@Service
public class DynamicSchedulerService {

	private final TaskScheduler taskscheduler;
	
	private ScheduledFuture<?> schedulerfuture;

	public DynamicSchedulerService(TaskScheduler taskscheduler) {
		super();
		this.taskscheduler = taskscheduler;
	}
	
	public void starttask(long interval) {
		schedulerfuture=taskscheduler
				.scheduleAtFixedRate(()-> System.out.println("Task Running.."),interval);
	}
	
	public void stoptask() {
		if(schedulerfuture !=null) {
			schedulerfuture.cancel(false);
		}
	}
}
