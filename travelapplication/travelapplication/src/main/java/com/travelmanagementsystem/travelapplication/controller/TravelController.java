package com.travelmanagementsystem.travelapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.travelmanagementsystem.travelapplication.entity.TravelPackage;
import com.travelmanagementsystem.travelapplication.service.TravelService;

@RestController
@RequestMapping("/travel")
public class TravelController {
	@Autowired
	private TravelService travelservice;

	@GetMapping("/getall")
	public List<TravelPackage> getall() {
		return travelservice.getall();
	}

	@GetMapping("/getbyid/{id}")
	public ResponseEntity<?> getbyid(@PathVariable int id) {
		return travelservice.getbyid(id);
	}

	@GetMapping("/getbyprice/{price}")
	public ResponseEntity<List<TravelPackage>> getbyprice(@PathVariable double price) {
		return travelservice.getbyprice(price);
	}

	

	@PostMapping("/add")
	public TravelPackage addnewpackage(@RequestBody TravelPackage t) {
		return travelservice.add(t);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable int id, @RequestBody TravelPackage t) {
		return travelservice.update(id, t);
	}

	@DeleteMapping("/deleteall")
	public void deleteall() {
		travelservice.deleteall();
	}

	@DeleteMapping("/deletebyid/{id}")
	public void deletebyid(@PathVariable int id) {
		travelservice.deletebyid(id);
	}

}
