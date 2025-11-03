package com.artgalleryapplication.ArtGallery.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Gallery {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int galleryid;
	private String galleryname;
	private String location;

	@ManyToMany(mappedBy = "galleries")
	@JsonIgnoreProperties("galleries")
	private List<Artist> artists = new ArrayList<>();

	public Gallery(int galleryid, String galleryname, String location, List<Artist> artists) {
		super();
		this.galleryid = galleryid;
		this.galleryname = galleryname;
		this.location = location;
		this.artists = artists;
	}

	public Gallery() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getGalleryid() {
		return galleryid;
	}

	public void setGalleryid(int galleryid) {
		this.galleryid = galleryid;
	}

	public String getGalleryname() {
		return galleryname;
	}

	public void setGalleryname(String galleryname) {
		this.galleryname = galleryname;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<Artist> getArtists() {
		return artists;
	}

	public void setArtists(List<Artist> artists) {
		this.artists = artists;
	}

}
