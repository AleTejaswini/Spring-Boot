package com.athletecountry.Athlete.Directory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.athletecountry.Athlete.Directory.model.Athlete;
import com.athletecountry.Athlete.Directory.model.Country;

public interface AthleteRepository extends JpaRepository<Athlete,Integer>{
	List<Athlete> findByCountry(Country country);
}
