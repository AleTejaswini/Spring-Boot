package com.artgalleryapplication.ArtGallery.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.artgalleryapplication.ArtGallery.model.Artist;
import com.artgalleryapplication.ArtGallery.model.Gallery;
import com.artgalleryapplication.ArtGallery.repository.ArtistRepository;
import com.artgalleryapplication.ArtGallery.repository.GalleryRepository;

@Service
public class GalleryService {
	@Autowired
	private GalleryRepository galleryrepository;
	@Autowired
	private ArtistRepository artistrepository;
	
	public List<Gallery> getgalleries() {
		 return galleryrepository.findAll();
		}
		
		public Gallery getgallery(int galleryid) {
			try {
				Gallery gallery = galleryrepository.findById(galleryid).get();
				return gallery;
			}
			catch(Exception e) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND);
			}
		}
		public Gallery addgallery(Gallery gallery) {
			List<Integer> artistids = new ArrayList<>();
			for(Artist artist : gallery.getArtists()) {
				artistids.add(artist.getArtistid());
			}
			try {
			List<Artist> completeartist = artistrepository.findAllById(artistids);
			if(artistids.size() != completeartist.size()) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"one or more ids are invalid");
			}
			for(Artist a : completeartist) {
				a.getGalleries().add(gallery);
			}
			galleryrepository.save(gallery);
			return gallery;
			} 
		catch (NoSuchElementException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "wrong artist");
		}}
		
		public Gallery updategallery(int galleryid, Gallery updatedgallery) {
			try {
				Gallery existinggallery = galleryrepository.findById(galleryid).get();
				List<Integer> artistids =new ArrayList<>();
				for(Artist artist: updatedgallery.getArtists()) {
					artistids.add(artist.getArtistid());
				}
				List<Artist> completeartist = artistrepository.findAllById(artistids);
				if(artistids.size()!=completeartist.size()) {
					throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"one or more ids are invalid");
				}
				for(Artist a: completeartist) {
					a.getGalleries().add(existinggallery);
				}
				existinggallery.setGalleryname(updatedgallery.getGalleryname());
				existinggallery.setLocation(updatedgallery.getLocation());
				existinggallery.setArtists(completeartist);

				galleryrepository.save(existinggallery);
				return  existinggallery;
			}
			catch(NoSuchElementException e) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND,"wrong artist");
			}
		}
		
		public void deletegallery(int galleryid) {
			try {
				Gallery gallery = galleryrepository.findById(galleryid).get();
				List<Artist> artists = gallery.getArtists();
				for(Artist artist:artists) {
					artist.getGalleries().remove(gallery);
				}
				artistrepository.saveAll(artists);
				galleryrepository.deleteById(galleryid);
			}
			catch(Exception e) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND);
			}
			throw new ResponseStatusException(HttpStatus.NO_CONTENT);
		}
	}
