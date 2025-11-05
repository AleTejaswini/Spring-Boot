package com.chefrestaurant.DineMaster.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chefrestaurant.DineMaster.model.Chef;
import com.chefrestaurant.DineMaster.model.Restaurant;

public interface ChefRepository extends JpaRepository<Chef,Integer>{
	
	List<Chef> findByRestaurant(Restaurant restaurant);
}
