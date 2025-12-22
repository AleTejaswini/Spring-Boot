package com.schedulerconfig.SchedulerDB.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.schedulerconfig.SchedulerDB.service.DynamicSchedulerService;

@RestController
public class SchedulerController {
	@Autowired
	private DynamicSchedulerService service;
	
	
	@GetMapping("/starttask/{id}")
	public String startTask(@PathVariable int id) {
		service.startTask(id);
		return "Task Started";
	}
	
	@GetMapping("/restarttask/{id}")
	public String reStartTask(@PathVariable int id) {
		service.reStart(id);
		return "Task ReStarted";
	}
	
	@GetMapping("/stoptask/{id}")
	public String stopTask(@PathVariable int id) {
		service.stopTask(id);
		return "Task stopped";
	}
	
}
