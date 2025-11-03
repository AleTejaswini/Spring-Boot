package com.artgalleryapplication.ArtGallery.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.artgalleryapplication.ArtGallery.model.Art;
import com.artgalleryapplication.ArtGallery.model.Artist;
import com.artgalleryapplication.ArtGallery.repository.ArtRepository;
import com.artgalleryapplication.ArtGallery.model.Gallery;
import com.artgalleryapplication.ArtGallery.repository.ArtistRepository;
import com.artgalleryapplication.ArtGallery.repository.GalleryRepository;

@Service
public class ArtistService {
	@Autowired
	private ArtistRepository artistrepository;
	@Autowired
	private ArtRepository artrepository;
	@Autowired
	private GalleryRepository galleryrepository;
	
	
	public List<Artist> getartists() {
	 return artistrepository.findAll();
	}
	
	public Artist getartist(int artistid) {
		try {
			Artist artist = artistrepository.findById(artistid).get();
			return artist;
		}
		catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	public Artist addartist(Artist artist) {
		List<Integer> galleryids = new ArrayList<>();
		for(Gallery gallery : artist.getGalleries()) {
			galleryids.add(gallery.getGalleryid());
		}
		try {
			List<Gallery> completegallery = galleryrepository.findAllById(galleryids);
			if(galleryids.size()!= completegallery.size()) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"one or more galleryids are invalid");
			}
			artist.setGalleries(completegallery);
			
			for(Gallery g:completegallery ) {
				g.getArtists().add(artist);
			}
			artistrepository.save(artist);
			return artist;
		}
	catch (NoSuchElementException e) {
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "wrong gallery");
	}
	
	}
	public Artist updateartist(int artistid, Artist updatedartist) {
		try {
			Artist existingartist = artistrepository.findById(artistid).get();
			List<Integer> galleryids =new ArrayList<>();
			for(Gallery gallery: updatedartist.getGalleries()) {
				galleryids.add(gallery.getGalleryid());
			}
			List<Gallery> completegallery = galleryrepository.findAllById(galleryids);
			if(galleryids.size()!=completegallery.size()) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"one or more ids are invalid");
			}
			for(Gallery g: completegallery) {
				g.getArtists().add(existingartist);
			}
			existingartist.setGalleries(completegallery);
			existingartist.setArtistname(updatedartist.getArtistname());
			existingartist.setGenre(updatedartist.getGenre());
			artistrepository.save(existingartist);
			return  existingartist;
		}
		catch(NoSuchElementException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"wrong gallery");
		}
	}
	
	public void deleteartist(int artistid) {
	
			Artist artist = artistrepository.findById(artistid)
					.orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
			List<Art> arts = artrepository.findByArtist(artist);
			artrepository.deleteAll(arts);
			
			List<Gallery> galleries = artist.getGalleries();
			for(Gallery gallery:galleries) {
				gallery.getArtists().remove(artist);
			}
			galleryrepository.saveAll(galleries);
			artistrepository.deleteById(artistid);
		}
		
		 
		
	
}
