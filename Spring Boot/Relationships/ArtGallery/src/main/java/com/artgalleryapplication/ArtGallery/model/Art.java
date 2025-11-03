package com.artgalleryapplication.ArtGallery.model;




import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Art {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int artid;
	private String arttitle;
	private String theme;

	@ManyToOne
	@JoinColumn(name = "artistid")
	private Artist artist;

	public Art(int artid, String arttitle, String theme, Artist artist) {
		super();
		this.artid = artid;
		this.arttitle = arttitle;
		this.theme = theme;
		this.artist = artist;
	}

	public Art() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getArtid() {
		return artid;
	}

	public void setArtid(int artid) {
		this.artid = artid;
	}

	public String getArttitle() {
		return arttitle;
	}

	public void setArttitle(String arttitle) {
		this.arttitle = arttitle;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}

}