package com.citycountry.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.citycountry.model.Country;

public interface CountryRepository extends JpaRepository<Country,Integer>{

}
