package com.artgalleryapplication.ArtGallery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.artgalleryapplication.ArtGallery.model.Artist;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Integer> {

}
