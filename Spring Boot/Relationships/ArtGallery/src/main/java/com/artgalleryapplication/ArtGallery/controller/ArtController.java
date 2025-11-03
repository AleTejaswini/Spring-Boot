package com.artgalleryapplication.ArtGallery.controller;

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

import com.artgalleryapplication.ArtGallery.model.Art;
import com.artgalleryapplication.ArtGallery.service.ArtService;

@RestController
@RequestMapping("/art")
public class ArtController {
	
	@Autowired
	private ArtService artservice;
	@GetMapping("/getarts")
	public List<Art> getarts() {
		return artservice.getarts();
	}
    
	@GetMapping("/getart/{artid}")
	public Art getart(@PathVariable int artid) {
		return artservice.getart(artid);
	}
	
	@PostMapping("/addart")
	public Art addart(@RequestBody Art art) {
		return artservice.addart(art);
	}
	
	@PutMapping("/updateart/{artid}")
	public Art updateart(@PathVariable int artid,@RequestBody Art updatedart) {
		return artservice.updateart(artid,updatedart);
	}
	
	@DeleteMapping("/deleteart/{artid}")
	public void deleteart(@PathVariable int artid) {
		 artservice.deleteart(artid);
	}
	
}