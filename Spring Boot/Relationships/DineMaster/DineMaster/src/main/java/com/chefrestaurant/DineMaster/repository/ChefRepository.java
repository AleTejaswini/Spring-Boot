package com.chefrestaurant.DineMaster.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chefrestaurant.DineMaster.model.Chef;

public interface ChefRepository extends JpaRepository<Chef,Integer>{

}
