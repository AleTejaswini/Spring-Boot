package com.artgalleryapplication.ArtGallery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.artgalleryapplication.ArtGallery.model.Art;
import com.artgalleryapplication.ArtGallery.model.Artist;
import com.artgalleryapplication.ArtGallery.repository.ArtRepository;
import com.artgalleryapplication.ArtGallery.repository.ArtistRepository;

@Service
public class ArtService {

	@Autowired
	private ArtRepository artrepository;
	@Autowired
	private ArtistRepository artistrepository;

	public List<Art> getarts() {
		return artrepository.findAll();
	}

	public Art getart(int artid) {
		try {
			Art art = artrepository.findById(artid).get();
			return art;
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There is no art with id: " + artid);
		}
	}

	public Art addart(Art art) {
		Artist artist = art.getArtist();
		int artistid = artist.getArtistid();
		Artist completeartist = artistrepository.findById(artistid).get();
		art.setArtist(completeartist);
		return artrepository.save(art);
	}

	public Art updatedart(int artid, Art updatedart) {
		try {
			Art existingart = artrepository.findById(artid).get();

			Artist artist = updatedart.getArtist();
			int artistid = artist.getArtistid();
			Artist completeartist = artistrepository.findById(artistid).get();

			existingart.setArttitle(updatedart.getArttitle());
			existingart.setTheme(updatedart.getTheme());
			existingart.setArtist(completeartist);

			return artrepository.save(existingart);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There is no art with id: " + artid);
		}
	}

	public void deleteart(int artid) {
		Art art = artrepository.findById(artid).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "There is no art with id: " + artid));

		art.setArtist(null);
		artrepository.save(art);
		artrepository.deleteById(artid);
	}
}
