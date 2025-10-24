package com.travelmanagementsystem.travelapplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.travelmanagementsystem.travelapplication.entity.TravelPackage;

public interface TravelRepository extends JpaRepository <TravelPackage,Integer>{

	
	List<TravelPackage> findByPrice(double price);

	
}
