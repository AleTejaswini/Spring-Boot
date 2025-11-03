package com.artgalleryapplication.ArtGallery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.artgalleryapplication.ArtGallery.model.Gallery;

public interface GalleryRepository extends JpaRepository<Gallery, Integer> {

}