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

import com.chefrestaurant.DineMaster.model.Chef;
import com.chefrestaurant.DineMaster.service.ChefService;

@RestController
@RequestMapping("/chef")
public class ChefController {

	@Autowired
	private ChefService chefservice;
	
	@GetMapping("/getchefs")
	public List<Chef> getchefs(){
		return chefservice.getchefs();
	}
	
	@GetMapping("/getchef/{chefid}")
	public Chef getchef(@PathVariable int chefid) {
		return chefservice.getchef(chefid);
	}
	
	@PostMapping("/addchef")
	public Chef addchef(@RequestBody Chef chef) {
		return chefservice.addchef(chef);
	}
	
	@PutMapping("/updatechef/{chefid}")
	public Chef updatechef(@PathVariable int chefid,@RequestBody Chef chef) {
		return chefservice.updatechef(chefid,chef);
	}
	@DeleteMapping("/deletechef/{chefid}")
	public void deletechef(@PathVariable int chefid) {
		 chefservice.deletechef(chefid);
	}
}
