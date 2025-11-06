package com.artgalleryapplication.ArtGallery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.artgalleryapplication.ArtGallery.model.Gallery;

@Repository
public interface GalleryRepository extends JpaRepository<Gallery, Integer> {

}
