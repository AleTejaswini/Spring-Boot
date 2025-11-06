package com.artgalleryapplication.ArtGallery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.artgalleryapplication.ArtGallery.model.Art;
import com.artgalleryapplication.ArtGallery.model.Artist;

@Repository
public interface ArtRepository extends JpaRepository<Art, Integer> {

	List<Art> findByArtist(Artist artist);
}
