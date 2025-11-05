package com.chefrestaurant.DineMaster.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chefrestaurant.DineMaster.model.Chef;
import com.chefrestaurant.DineMaster.model.Restaurant;
@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant,Integer>{

	
}
