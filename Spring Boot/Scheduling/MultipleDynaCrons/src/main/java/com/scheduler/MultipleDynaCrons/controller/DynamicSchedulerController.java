package com.scheduler.MultipleDynaCrons.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.scheduler.MultipleDynaCrons.service.DynamicScehdulerService;

@RestController
public class DynamicSchedulerController {
	@Autowired
	private DynamicScehdulerService service;
	
	@GetMapping("/startAll")
	public String startAll() {
		service.startAll();
		return "All tasks started";
	}
	
	@GetMapping("/stopAlltask")
	public String stopTask() {
		service.stopAll();
		return "All Tasks stopped";
	}
}
