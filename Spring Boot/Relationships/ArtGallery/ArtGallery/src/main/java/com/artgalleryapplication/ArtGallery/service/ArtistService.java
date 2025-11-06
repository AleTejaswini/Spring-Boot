package com.artgalleryapplication.ArtGallery.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.artgalleryapplication.ArtGallery.model.Art;
import com.artgalleryapplication.ArtGallery.model.Artist;
import com.artgalleryapplication.ArtGallery.model.Gallery;
import com.artgalleryapplication.ArtGallery.repository.ArtRepository;
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
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There is no artist with id :" + artistid);
		}
	}

	public Artist addartist(Artist artist) {
		List<Integer> galleryids = new ArrayList<>();
		for (Gallery gallery : artist.getGalleries()) {
			galleryids.add(gallery.getGalleryid());
		}

		List<Gallery> completegalleries = galleryrepository.findAllById(galleryids);
		if (galleryids.size() != completegalleries.size()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "One or more gallery ids are invalid");
		}
		artist.setGalleries(completegalleries);
		for (Gallery g : completegalleries) {
			g.getArtists().add(artist);
		}
		return artistrepository.save(artist);
	}

	public Artist updateartist(int artistid, Artist updatedartist) {
		try {
			Artist existingartist = artistrepository.findById(artistid).get();
			List<Integer> galleryids = new ArrayList<>();
			for (Gallery gallery : updatedartist.getGalleries()) {
				galleryids.add(gallery.getGalleryid());
			}
			List<Gallery> completegalleries = galleryrepository.findAllById(galleryids);
			if (galleryids.size() != completegalleries.size()) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "One or more gallery ids are invalid");
			}
			existingartist.setGalleries(completegalleries);
			existingartist.setArtistname(updatedartist.getArtistname());
			existingartist.setGenre(updatedartist.getGenre());

			artistrepository.save(existingartist);
			return existingartist;
		} catch (NoSuchElementException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There is no artist with id : " + artistid);
		}
	}

	public void deleteartist(int artistid) {
		Artist artist = artistrepository.findById(artistid).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "There is no artist with id: " + artistid));
		List<Art> arts = artrepository.findByArtist(artist);
		for (Art art : arts) {
			art.setArtist(null);
		}
		List<Gallery> galleries = artist.getGalleries();
		for (Gallery gallery : galleries) {
			gallery.setArtists(null);
		}
		galleryrepository.saveAll(galleries);
		artrepository.deleteAll(arts);
		artistrepository.deleteById(artistid);

	}
}
