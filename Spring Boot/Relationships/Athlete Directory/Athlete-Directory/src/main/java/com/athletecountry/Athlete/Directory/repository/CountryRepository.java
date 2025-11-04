package com.athletecountry.Athlete.Directory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.athletecountry.Athlete.Directory.model.Country;

public interface CountryRepository extends JpaRepository<Country,Integer>{

}
