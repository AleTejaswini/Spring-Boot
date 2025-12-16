package com.dynamicscheduler.Scheduler;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/scheduler")
public class DynamicController {

	private final DynamicSchedulerService dynamicschedulerservice;

	public DynamicController(DynamicSchedulerService dynamicschedulerservice) {
		super();
		this.dynamicschedulerservice = dynamicschedulerservice;
	}
	
	
	@PostMapping("/start/{seconds}")
	public String start(@PathVariable long seconds) {
		dynamicschedulerservice.starttask(seconds*1000);
		return "scheduler started";
	}
	
	@PostMapping("/stop")
	public String stop(){
		dynamicschedulerservice.stoptask();
		return "scheduler stopped";
	}
}

