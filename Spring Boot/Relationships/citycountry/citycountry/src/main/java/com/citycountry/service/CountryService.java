package com.citycountry.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.citycountry.model.Country;
import com.citycountry.repository.CountryRepository;

@Service
public class CountryService {

	@Autowired
	private CountryRepository countryrepository;
	
	public List<Country> getcountries(){
		return countryrepository.findAll();
	}
	
	public Country getcountry(int countryid) {
		try {
			Country country = countryrepository.findById(countryid).get();
			return country;
		}
		catch(Exception e) {
			throw new  ResponseStatusException(HttpStatus.NOT_FOUND,"there is no country with id: "+countryid );
		}
	}
	
	public Country addcountry(Country country) {
		return countryrepository.save(country);
	}
	
	public Country updatecountry(int countryid ,Country newcountry) {
		try {
		Country existingcountry = countryrepository.findById(countryid).get();
		existingcountry.setCountryname(newcountry.getCountryname());
		countryrepository.save(existingcountry);
		return existingcountry;
		}
		catch(Exception e) {
			throw new  ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		
	}
	
	public void deletecountry(int countryid) {
		countryrepository.deleteById(countryid);
	}
}
