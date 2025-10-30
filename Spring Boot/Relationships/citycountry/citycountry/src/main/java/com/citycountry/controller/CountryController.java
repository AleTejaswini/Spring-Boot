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

import com.citycountry.model.Country;
import com.citycountry.service.CountryService;

@RestController
@RequestMapping("/country")
public class CountryController {
	
	@Autowired
	private CountryService countryservice;
	
	@GetMapping("/getcountries")
	public List<Country> getcountries(){
		return countryservice.getcountries();
	}
	@GetMapping("/getcountry/{countryid}")
	public Country getcountry(@PathVariable int countryid) {
		return countryservice.getcountry(countryid);
	}
	
	@PostMapping("/addcountry")
	public Country addcountry(@RequestBody Country country) {
		return countryservice.addcountry(country);
	}
	
	@PutMapping("/updatecountry/{countryid}")
	public Country updatecountry(@PathVariable int countryid,@RequestBody Country country) {
		return countryservice.updatecountry(countryid, country);
	}
	
	@DeleteMapping("/deletecountry/{countryid}")
	public void deletecountry(@PathVariable int  countryid) {
		 countryservice.deletecountry(countryid);
	}
}
