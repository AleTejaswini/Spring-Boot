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

import com.artgalleryapplication.ArtGallery.model.Artist;

import com.artgalleryapplication.ArtGallery.service.ArtistService;

@RestController
@RequestMapping("/artist")
public class ArtistController {
	@Autowired
	private ArtistService artistservice;
	@GetMapping("/getartists")
	public List<Artist> getartists() {
		return artistservice.getartists();
	}
    
	@GetMapping("/getartist/{artistid}")
	public Artist getartist(@PathVariable int artistid) {
		return artistservice.getartist(artistid);
	}
	
	@PostMapping("/addartist")
	public Artist addartist(@RequestBody Artist artist) {
		return artistservice.addartist(artist);
	}
	
	@PutMapping("/updateartist/{artistid}")
	public Artist updateartist(@PathVariable int artistid,@RequestBody Artist updatedartist) {
		return artistservice.updateartist(artistid,updatedartist);
	}
	
	@DeleteMapping("/deleteartist/{artistid}")
	public void deleteartist(@PathVariable int artistid) {
		 artistservice.deleteartist(artistid);
	}
	
}

