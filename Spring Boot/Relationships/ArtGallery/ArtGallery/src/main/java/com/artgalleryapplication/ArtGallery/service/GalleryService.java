package com.artgalleryapplication.ArtGallery.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
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
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There is no gallery with id:" + galleryid);
		}
	}

	public Gallery addgallery(Gallery gallery) {
		List<Integer> artistids = new ArrayList<>();

		for (Artist artist : gallery.getArtists()) {
			artistids.add(artist.getArtistid());
		}

		List<Artist> completeartists = artistrepository.findAllById(artistids);
		if (artistids.size() != completeartists.size()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "One or more artist ids are invalid");
		}
		gallery.setArtists(completeartists);
		for (Artist a : completeartists) {
			a.getGalleries().add(gallery);
		}
		return galleryrepository.save(gallery);
	}

	public Gallery updategallery(int galleryid, Gallery updatedgallery) {
		Gallery existinggallery = galleryrepository.findById(galleryid).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "There is no gallery with id: " + galleryid));

		List<Integer> artistids = new ArrayList<>();
		for (Artist artist : updatedgallery.getArtists()) {
			artistids.add(artist.getArtistid());
		}
		List<Artist> completeartists = artistrepository.findAllById(artistids);
		if (artistids.size() != completeartists.size()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "One or more artist ids are invalid");
		}
		existinggallery.setArtists(completeartists);

		for (Artist a : completeartists) {
			a.getGalleries().add(existinggallery);
		}
		existinggallery.setLocation(updatedgallery.getLocation());
		existinggallery.setName(updatedgallery.getName());

		return galleryrepository.save(existinggallery);
	}

	public void deletegallery(int galleryid) {
		Gallery gallery = galleryrepository.findById(galleryid).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "There is no gallery with id: " + galleryid));
		List<Artist> artists = gallery.getArtists();
		for (Artist artist : artists) {
			artist.setGalleries(null);
		}
		artistrepository.saveAll(artists);
		galleryrepository.deleteById(galleryid);
	}

}
