package com.writermagazine.Storyhub.controller;

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

import com.writermagazine.Storyhub.model.Magazine;
import com.writermagazine.Storyhub.service.MagazineService;



@RestController
@RequestMapping("/magazine")
public class MagazineController {
	
	@Autowired
	private MagazineService magazineservice;
	
	@GetMapping("/getmagazine")
	public List<Magazine> getmagazines(){
		return magazineservice.getmagazines();
	}
	
	@GetMapping("/getmagazine/{magazineid}")
	public Magazine getmagazine(@PathVariable int magazineid) {
		return magazineservice.getmagazine(magazineid);
	}
	
	@PostMapping("/addmagazine")
	public Magazine addmagazine(@RequestBody Magazine magazine) {
		return magazineservice.addmagazine(magazine);
	}
	@PutMapping("/updatemagazine/{magazineid}")
	public Magazine updatemagazine(@PathVariable int magazineid ,@RequestBody Magazine updatedmagazine) {
		return magazineservice.updatemagazine(magazineid, updatedmagazine);
	}
	
	@DeleteMapping("/deletemagazine/{magazineid}")
	public void deletemagazine(@PathVariable int magazineid) {
		 magazineservice.deletemagazine(magazineid);
	}
}