package com.citycountry.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.citycountry.model.City;
import com.citycountry.model.Country;
import com.citycountry.repository.CityRepository;
import com.citycountry.repository.CountryRepository;

@Service
public class CityService {
	@Autowired
	private CityRepository cityrepository;
	
	@Autowired
	private CountryRepository countryrepository;
	
	public List<City> getcities(){
		return cityrepository.findAll();
	}
	
	public City getcity(int cityid) {
		try {
			City city = cityrepository.findById(cityid).get();
			return city;
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Wrong cityid");
		}
	}
	
	public City addcity(City city) {
	try {
		Country country = city.getCountry();
		int countryid = country.getCountryid();
		Country completecountry = countryrepository.findById(countryid).get();
		city.setCountry(completecountry);
		cityrepository.save(city);
		return city;
	} catch (Exception e) {
		throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Wrong countryid");
	}
	}
	
	public City updatecity(int cityid,City newcity) {
		try {
			City existingcity = cityrepository.findById(cityid).get();
			Country country = newcity.getCountry();
			int countryid = country.getCountryid();
			Country completecountry = countryrepository.findById(countryid).get();
			existingcity.setCountry(completecountry);
			existingcity.setCityname(newcity.getCityname());
			cityrepository.save(existingcity);
			return existingcity;
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Wrong countryid");
		}
		
		
	}
	
	public void deletecity(int cityid) {
		cityrepository.deleteById(cityid);
	}
	
	
}
