package com.artgalleryapplication.ArtGallery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.artgalleryapplication.ArtGallery.model.Art;
import com.artgalleryapplication.ArtGallery.model.Artist;

public interface ArtistRepository extends JpaRepository<Artist, Integer> {
	
}
