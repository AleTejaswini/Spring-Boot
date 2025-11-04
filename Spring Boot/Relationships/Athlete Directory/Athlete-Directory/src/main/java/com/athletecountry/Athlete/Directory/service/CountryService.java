package com.athletecountry.Athlete.Directory.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.athletecountry.Athlete.Directory.model.Athlete;
import com.athletecountry.Athlete.Directory.model.Country;
import com.athletecountry.Athlete.Directory.repository.AthleteRepository;
import com.athletecountry.Athlete.Directory.repository.CountryRepository;

@Service
public class CountryService {
	@Autowired
	private CountryRepository countryrepository;
	
	@Autowired
	private AthleteRepository athleterepository;
	
	
	
	public List<Country> getcountries(){
		return countryrepository.findAll();
	}
	
	public Country getcountry(int countryid) {
		try {
			Country country = countryrepository.findById(countryid).get();
			return country;
		}
		catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"there is no country with id: "+countryid);
		}
	}
	
	public Country addcountry(Country country) {
		return countryrepository.save(country);
	}
	
	public Country updatecountry(int countryid,Country updatedcountry) {
		try {
			Country existingcountry = countryrepository.findById(countryid).get();
			existingcountry.setCountryname(updatedcountry.getCountryname());
			countryrepository.save(existingcountry);
			return existingcountry;
		}
		catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"there is no country with id: "+countryid);
		}
	}
	public void deletecountry(int countryid) {
		try {
			Country country = countryrepository.findById(countryid).get();
			List<Athlete> athletes = athleterepository.findByCountry(country);
			athleterepository.deleteAll(athletes);
			countryrepository.delete(country);
		}
		catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"there is no country with id: "+countryid);
		}
	}
	
	
}
