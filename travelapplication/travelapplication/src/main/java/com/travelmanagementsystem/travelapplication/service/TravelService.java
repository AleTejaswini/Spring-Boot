package com.travelmanagementsystem.travelapplication.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.travelmanagementsystem.travelapplication.entity.TravelPackage;
import com.travelmanagementsystem.travelapplication.repository.TravelRepository;

@Service
public class TravelService {
	@Autowired
	private TravelRepository travelrepository;
	
	public TravelPackage add(TravelPackage t) {
		return travelrepository.save(t);
	}
	
	public List<TravelPackage> getall() {
		return travelrepository.findAll();
    }
	
	
	public ResponseEntity<List<TravelPackage>> getbyprice(double price){
		List<TravelPackage> existing= travelrepository.findByPrice(price);
		if(existing==null)
			ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found with price : " +price);
		return ResponseEntity.ok(new ArrayList<>(existing));
	}
	
	public ResponseEntity<?> getbyid(int id) {
		TravelPackage existing =  travelrepository.findById(id).orElse(null);
		if(existing==null) {
			 ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found with id : " +id);
		}
		return ResponseEntity.ok(existing);
	}
	
	public ResponseEntity<?> update(int id , TravelPackage t){
		TravelPackage existing =  travelrepository.findById(id).orElse(null);
		if(existing==null) {
			ResponseEntity.status(HttpStatus.NOT_FOUND).body("there is no package with id: "+id);
		}
		existing.setDestination(t.getDestination());
		existing.setAvailability(t.getAvailability());
		existing.setHoursduration(t.getHoursduration());
		existing.setPrice(t.getPrice());
		
		return ResponseEntity.ok(existing);
		
	}
	
	
	public void deleteall() {
		travelrepository.deleteAll();
	}
	
	public void deletebyid(int id) {
		travelrepository.deleteById(id);
	}
	
	

}
