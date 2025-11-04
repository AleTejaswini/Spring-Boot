package com.athletecountry.Athlete.Directory.service;

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
public class AthleteService {

	@Autowired
	private AthleteRepository athleterepository;

	@Autowired
	private CountryRepository countryrepository;

	public List<Athlete> getathletes() {
		return athleterepository.findAll();
	}

	public Athlete getathlete(int athleteid) {
		try {
			Athlete athlete = athleterepository.findById(athleteid).get();
			return athlete;
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "there is no athlete with id: " + athleteid);
		}
	}

	public Athlete addathlete(Athlete athlete) {
		Country country = athlete.getCountry();
		int countryid = country.getCountryid();
		try {
			Country completecountry = countryrepository.findById(countryid).get();
			athlete.setCountry(completecountry);
			athleterepository.save(athlete);
			return athlete;
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "wrong country");
		}
	}

	public Athlete updateathlete(int athleteid, Athlete updatedathlete) {
		try {
			Athlete existingathlete = athleterepository.findById(athleteid).get();
			Country country = updatedathlete.getCountry();
			int countryid = country.getCountryid();
			Country completecountry = countryrepository.findById(countryid).get();

			existingathlete.setCountry(completecountry);
			existingathlete.setName(updatedathlete.getName());
			existingathlete.setSport(updatedathlete.getSport());

			athleterepository.save(existingathlete);
			return existingathlete;
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "there is no athlete with id: " + athleteid);
		}
	}

	public void deleteathlete(int athleteid) {
		try {
			Athlete athlete = athleterepository.findById(athleteid).get();
			athleterepository.delete(athlete);

		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "there is no athlete with id: " + athleteid);
		}
	}
}
