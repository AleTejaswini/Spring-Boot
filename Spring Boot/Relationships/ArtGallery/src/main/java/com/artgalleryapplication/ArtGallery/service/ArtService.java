package com.artgalleryapplication.ArtGallery.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.artgalleryapplication.ArtGallery.model.Art;
import com.artgalleryapplication.ArtGallery.model.Artist;
//import com.artgalleryapplication.ArtGallery.model.Gallery;
import com.artgalleryapplication.ArtGallery.repository.ArtRepository;
import com.artgalleryapplication.ArtGallery.repository.ArtistRepository;
//import com.artgalleryapplication.ArtGallery.repository.GalleryRepository;

@Service
public class ArtService {

	@Autowired
	private ArtRepository artrepository;

	@Autowired
	private ArtistRepository artistrepository;
	
//	@Autowired
//	private GalleryRepository galleryrepository;


	public List<Art> getarts() {
		return artrepository.findAll();
	}

	public Art getart(int artid) {
		try {
			Art art = artrepository.findById(artid).get();
			return art;
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}


	public Art addart(Art art) {
		try {
			Artist artist = art.getArtist();
			int artistid = artist.getArtistid();
			
			Artist completeartist = artistrepository.findById(artistid).get();
			art.setArtist(completeartist);
			artrepository.save(art);
			return art;
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"wrong artist");
		}
	

		
		
	}


	public Art updateart(int artid, Art updatedart) {
		try {
			Art existingart = artrepository.findById(artid).get();
			existingart.setArttitle(updatedart.getArttitle());
			existingart.setTheme(updatedart.getTheme());
			Artist artist = existingart.getArtist();
			int artistid = artist.getArtistid();
			Artist completeartist = artistrepository.findById(artistid).get();
			existingart.setArtist(completeartist);
			artrepository.save(existingart);
			return existingart;
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	public void deleteart(int artid) {
	    Art art = artrepository.findById(artid)
	        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

	    artrepository.delete(art);
	}


}