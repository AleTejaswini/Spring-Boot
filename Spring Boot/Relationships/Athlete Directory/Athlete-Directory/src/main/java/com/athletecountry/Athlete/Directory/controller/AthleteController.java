package com.athletecountry.Athlete.Directory.controller;

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

import com.athletecountry.Athlete.Directory.model.Athlete;
import com.athletecountry.Athlete.Directory.service.AthleteService;


@RestController
@RequestMapping("/athlete")
public class AthleteController {

	@Autowired
	private AthleteService athleteservice;
	
	@GetMapping("/getathletes")
	public List<Athlete> getathletes(){
		return athleteservice.getathletes();
	}
	
	@GetMapping("/getathlete/{athleteid}")
	public Athlete getathlete(@PathVariable int athleteid) {
		return athleteservice.getathlete(athleteid);
	}
	
	@PostMapping("/addathlete")
	public Athlete addathlete(@RequestBody Athlete athlete) {
		return athleteservice.addathlete(athlete);
	}
	
	@PutMapping("/updateathlete/{athleteid}")
	public Athlete updateathlete(@PathVariable int athleteid,@RequestBody Athlete updatedathlete) {
		return athleteservice.updateathlete(athleteid, updatedathlete);
	}
	
	@DeleteMapping("/deleteathlete/{athleteid}")
	public void deleteathlete(@PathVariable int athleteid) {
		athleteservice.deleteathlete(athleteid);
	}
}
