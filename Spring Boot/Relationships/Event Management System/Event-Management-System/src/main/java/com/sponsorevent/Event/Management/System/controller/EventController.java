package com.sponsorevent.Event.Management.System.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sponsorevent.Event.Management.System.model.Event;
import com.sponsorevent.Event.Management.System.service.EventService;

@RestController
@RequestMapping("/event")
public class EventController {
	@Autowired
	private EventService eventservice;
	
	@GetMapping("/getevents")
	public List<Event> getevents(){
		return eventservice.getevents();
	}
	
	@GetMapping("/getevent/{eventid}")
	public Event getevent(@PathVariable int eventid) {
		return eventservice.getevent(eventid);
	}
	
	@PostMapping("/addevent")
	public Event addevent(@RequestBody Event event) {
		return eventservice.addevent(event);
	}
	
	@PutMapping("/updateevent/{eventid}")
	public Event updateevent(@PathVariable int eventid,@RequestBody Event event) {
		return eventservice.updateevent(eventid, event);
	}
	
	@DeleteMapping("deleteevent/{eventid}")
	public void deleteevent(@PathVariable int eventid) {
		eventservice.deleteevent(eventid);
	}

}
