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

import com.artgalleryapplication.ArtGallery.model.Gallery;
import com.artgalleryapplication.ArtGallery.service.GalleryService;

@RestController
@RequestMapping("/gallery")
public class GalleryController {

	@Autowired
	private GalleryService galleryservice;

	@GetMapping("/getgalleries")
	public List<Gallery> getgalleries() {
		return galleryservice.getgalleries();
	}

	@GetMapping("/getgallery/{galleryid}")
	public Gallery getgallery(@PathVariable int galleryid) {
		return galleryservice.getgallery(galleryid);
	}

	@PostMapping("/addgallery")
	public Gallery addgallery(@RequestBody Gallery gallery) {
		return galleryservice.addgallery(gallery);
	}

	@PutMapping("/updategallery/{galleryid}")
	public Gallery updategallery(@PathVariable int galleryid, @RequestBody Gallery updatedgallery) {
		return galleryservice.updategallery(galleryid, updatedgallery);
	}

	@DeleteMapping("/deletegallery/{galleryid}")
	public void deletegallery(@PathVariable int galleryid) {
		galleryservice.deletegallery(galleryid);
	}

}
