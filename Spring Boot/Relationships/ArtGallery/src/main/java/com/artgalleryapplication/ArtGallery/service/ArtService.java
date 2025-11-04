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
import com.artgalleryapplication.ArtGallery.model.Gallery;
//import com.artgalleryapplication.ArtGallery.model.Gallery;
import com.artgalleryapplication.ArtGallery.repository.ArtRepository;
import com.artgalleryapplication.ArtGallery.repository.ArtistRepository;
import com.artgalleryapplication.ArtGallery.repository.GalleryRepository;

@Service
public class ArtService {

	@Autowired
	private ArtRepository artrepository;

	@Autowired
	private ArtistRepository artistrepository;
	
	@Autowired
	private GalleryRepository galleryrepository;


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
	    Artist artist = art.getArtist();
	    int artistid = artist.getArtistid();

	    try {
	        // ✅ Fetch the complete artist from DB
	        Artist completeartist = artistrepository.findById(artistid)
	                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Artist not found"));

	        // ✅ Get galleries linked to that artist
	        List<Gallery> galleries = completeartist.getGalleries();

	        // ✅ Link artist & galleries to art
	        art.setArtist(completeartist);
	        for (Gallery g : galleries) {
	            g.getArtists().add(completeartist); // ensure bidirectional sync
	        }

	        // ✅ Save art
	        artrepository.save(art);
	        return art;

	    } catch (Exception e) {
	        throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error while adding art");
	    }
	

		
		
	}


	public Art updateart(int artid, Art updatedart) {
	    try {
	        // ✅ Fetch existing art record
	        Art existingart = artrepository.findById(artid)
	                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Art not found"));

	        // ✅ Get artist from updated art
	        Artist artist = updatedart.getArtist();
	        int artistid = artist.getArtistid();

	        // ✅ Fetch full artist info from DB
	        Artist completeartist = artistrepository.findById(artistid)
	                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Artist not found"));

	        // ✅ Get all galleries linked with this artist
	        List<Gallery> galleries = completeartist.getGalleries();

	        // ✅ Keep bidirectional sync
	        for (Gallery g : galleries) {
	            g.getArtists().add(completeartist);
	        }

	        // ✅ Update art details
	        existingart.setArttitle(updatedart.getArttitle());
	        existingart.setTheme(updatedart.getTheme());
	        existingart.setArtist(completeartist);

	        // ✅ Save and return updated art
	        artrepository.save(existingart);
	        return existingart;

	    } catch (ResponseStatusException e) {
	        throw e; // rethrow known errors
	    } catch (Exception e) {
	        throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error while updating art");
	    }
	}

	public void deleteart(int artid) {
	    try {
	        Art art = artrepository.findById(artid)
	                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Art not found"));

	        // If you want to update artist ↔ gallery links when art is deleted:
	        Artist artist = art.getArtist();
	        if (artist != null) {
	            // If artist has galleries and you want to do any cleanup, you can:
	            // List<Gallery> galleries = artist.getGalleries();
	            // for (Gallery g : galleries) { /* optional cleanup */ }
	            // artistrepository.save(artist);
	        }

	        // Simply delete the art
	        artrepository.deleteById(artid);
	    } catch (NoSuchElementException e) {
	        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Art not found");
	    } catch (Exception e) {
	        throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error deleting art");
	    }

	    throw new ResponseStatusException(HttpStatus.NO_CONTENT);
	}


}