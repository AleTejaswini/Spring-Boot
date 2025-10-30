package com.citycountry.controller;

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

import com.citycountry.model.City;
import com.citycountry.service.CityService;

@RestController
@RequestMapping("/city")
public class CityController {

	@Autowired
	private CityService cityservice;
	
	@GetMapping("/getcities")
	public List<City> getcities(){
		return cityservice.getcities();
	}
	
	@GetMapping("/getcity/{cityid}")
	public City getcity(@PathVariable int cityid) {
		return cityservice.getcity(cityid);
	}
	
	@PostMapping("/addcity")
	public City addcity(@RequestBody City city) {
		return cityservice.addcity(city);
	}
	
	@PutMapping("/updatecity/{cityid}")
	public City updatecity(@PathVariable int cityid,@RequestBody City city) {
		return cityservice.updatecity(cityid, city);
	}
	
	@DeleteMapping("/deletecity/{cityid}")
	public void deletecity(@PathVariable int cityid) {
		cityservice.deletecity(cityid);
	}
}
