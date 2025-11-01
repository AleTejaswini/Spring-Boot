package com.bookpublisher.relationship.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookpublisher.relationship.model.Publisher;
import com.bookpublisher.relationship.service.PublisherService;

@RestController
@RequestMapping("/publisher")
public class PublisherController {

	@Autowired
	private PublisherService publisherservice;

	@GetMapping("/getall")
	public List<Publisher> getpublishers() {
		return publisherservice.getpublishers();
	}

	@GetMapping("getbyid/{publisherid}")
	public Optional<Publisher> getpublisher(@PathVariable int publisherid) {
		return publisherservice.getpublisher(publisherid);
	}

	@PostMapping("/addpublisher")
	public Publisher addpublisher(@RequestBody Publisher publisher) {
		return publisherservice.addpublisher(publisher);
	}

	@PutMapping("/updatepublisher/{publisherid}")
	public Publisher updatepublisher(@PathVariable int publisherid, @RequestBody Publisher newpublisher) {
		return publisherservice.updatepublisher(publisherid, newpublisher);
	}

	@DeleteMapping("/deletepublisher/{publisherid}")
	public void deletepublisher(@PathVariable int publisherid) {
		publisherservice.deletepublisher(publisherid);
	}
}

