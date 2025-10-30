package com.chefrestaurant.DineMaster.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.chefrestaurant.DineMaster.model.Restaurant;
import com.chefrestaurant.DineMaster.repository.RestaurantRepository;

@Service
public class RestaurantService {
	@Autowired
	private RestaurantRepository restaurantrepository;
	
	public List<Restaurant> getrestaurants(){
		return restaurantrepository.findAll();
	}
	
	public Restaurant getrestaurant(int id) {
		Restaurant restaurant = restaurantrepository.findById(id)
				.orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Not found"));
		return restaurant;
	}
	
	public Restaurant addrestaurant(Restaurant restaurant) {
		return restaurantrepository.save(restaurant);
	}
	
	public Restaurant updaterestaurant(int id, Restaurant newrestaurant) {
		Restaurant existingrestaurant = restaurantrepository.findById(id)
				.orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Not found"));
		existingrestaurant.setName(newrestaurant.getName());
		existingrestaurant.setAddress(newrestaurant.getAddress());
		existingrestaurant.setCusineType(newrestaurant.getCusineType());
		existingrestaurant.setRating(newrestaurant.getRating());
		restaurantrepository.save(existingrestaurant);
		return existingrestaurant;
	}
	
	public void deleterestaurant(int id) {
		restaurantrepository.deleteById(id);
	}
	
}
