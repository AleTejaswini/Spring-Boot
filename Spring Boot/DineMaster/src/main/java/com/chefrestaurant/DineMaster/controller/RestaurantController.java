package com.chefrestaurant.DineMaster.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chefrestaurant.DineMaster.model.Restaurant;
import com.chefrestaurant.DineMaster.service.RestaurantService;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {
	
	@Autowired
	private RestaurantService restaurantservice;
	
	@GetMapping("/getrestaurants")
	public List<Restaurant> getrestaurants(){
		return restaurantservice.getrestaurants();
	}
	
	@GetMapping("/getrestaurant/{id}")
	public Restaurant getrestaurant(@PathVariable int id) {
		return restaurantservice.getrestaurant(id);
	}
	
	@PostMapping("/addrestaurant")
	public Restaurant addrestaurant(@RequestBody Restaurant restaurant) {
		return restaurantservice.addrestaurant(restaurant);
	}
	
	@PutMapping("/updaterestaurant/{id}")
	public Restaurant updaterestaurant(@PathVariable int id,@RequestBody Restaurant restaurant) {
		return restaurantservice.updaterestaurant(id, restaurant);
	}
	
	@DeleteMapping("/deleterestaurant/{id}")
	public void deleterestaurant(@PathVariable int id) {
		restaurantservice.deleterestaurant(id);
	}
}
