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
	
	
	public ResponseEntity<?> getbyprice(double price){
		List<TravelPackage> existing= travelrepository.findByPrice(price);
		if(existing.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found with price : " +price);
		}return ResponseEntity.ok(new ArrayList<>(existing));
	}
	
	public ResponseEntity<?> getbyid(int packageid) {
		TravelPackage existing =  travelrepository.findById(packageid).orElse(null);
		if(existing==null) {
			 return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found with id : " +packageid);
		}
		return ResponseEntity.ok(existing);
	}
	
	public ResponseEntity<?> update(int packageid , TravelPackage t){
		TravelPackage existing =  travelrepository.findById(packageid).orElse(null);
		if(existing==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("there is no package with id: "+packageid);
		}
		existing.setDestination(t.getDestination());
		existing.setAvailability(t.getAvailability());
		existing.setHoursduration(t.getHoursduration());
		existing.setPrice(t.getPrice());
		
		travelrepository.save(existing);
		return ResponseEntity.ok(existing);
		
	}
	
	
	public ResponseEntity<?> deleteall() {
		travelrepository.deleteAll();
		return ResponseEntity.ok("Deleted all packages sucessfully" );
	}
	
	public ResponseEntity<?> deletebyid(int id) {
		TravelPackage existing = travelrepository.findById(id).orElse(null);
		if(existing!=null) {
			
			  travelrepository.deleteById(id);
			return ResponseEntity.ok("Deleted sucessfully");
		}
		
		 return ResponseEntity.status(HttpStatus.NOT_FOUND).body("There is no id with : "+id);
		
	}
	
	public ResponseEntity<?> updatespecific(int id ,TravelPackage t) {
		TravelPackage existing = travelrepository.findById(id).orElse(null);
		if(existing==null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("TravelPackage not found with id : "+id);
		String dest = t.getDestination();
		Integer hdu= t.getHoursduration();
		Double pr = t.getPrice();
		Boolean avai= t.getAvailability();
		if(dest!=null)
			existing.setDestination(t.getDestination());
		if(hdu!=null && hdu>0)
			existing.setHoursduration(t.getHoursduration());
		if(pr!=null && pr >0)
			existing.setPrice(t.getPrice());
		if(avai!=null)
			existing.setAvailability(t.getAvailability());
		 TravelPackage tp =travelrepository.save(existing);
		 
		 return ResponseEntity.ok(tp);
		 
	}

}
