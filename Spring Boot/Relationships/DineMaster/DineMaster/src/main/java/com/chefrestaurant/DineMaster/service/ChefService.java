package com.chefrestaurant.DineMaster.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.chefrestaurant.DineMaster.model.Chef;
import com.chefrestaurant.DineMaster.model.Restaurant;
import com.chefrestaurant.DineMaster.repository.ChefRepository;
import com.chefrestaurant.DineMaster.repository.RestaurantRepository;

@Service
public class ChefService {

	@Autowired
	private ChefRepository chefrepository;
	
	@Autowired
	private RestaurantRepository restaurantrepository;
	
	public List<Chef> getchefs(){
		return chefrepository.findAll();
	}
	public Chef getchef(int id) {
		Chef chef = chefrepository.findById(id)
				.orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
		return chef;
	}
	
	public Chef addchef(Chef chef) {
		Restaurant restaurant = chef.getRestaurant();
		int restaurantid =restaurant.getId();
		Restaurant completerestaurant =  restaurantrepository.findById(restaurantid)
				.orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
		chef.setRestaurant(completerestaurant);
		chefrepository.save(chef);
		return chef;
	}
	
	public Chef updatechef(int chefid,Chef newchef) {
		Chef existingchef = chefrepository.findById(chefid)
				.orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
		Restaurant restaurant = newchef.getRestaurant();
		int restaurantid =restaurant.getId();
		Restaurant completerestaurant = restaurantrepository.findById(restaurantid)
				.orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
		existingchef.setRestaurant(completerestaurant);
		existingchef.setFirstName(newchef.getFirstName());
		existingchef.setLastName(newchef.getLastName());
		existingchef.setExpertise(newchef.getExpertise());
		existingchef.setExperienceYears(newchef.getExperienceYears());
		chefrepository.save(existingchef);
		return existingchef;
		
	}
	
	public void deletechef(int chefid) {
		chefrepository.deleteById(chefid);
	}
}
