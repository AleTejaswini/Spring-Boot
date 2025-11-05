package com.writermagazine.Storyhub.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
@Entity
public class Magazine {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int magazineid;	
	private String magazinename;	
	private String publicationdate;	
	
	@ManyToMany(mappedBy = "magazines")
	@JsonIgnoreProperties("magazines")
	private List<Writer> writers =new ArrayList<>();
	
	public Magazine(int magazineid, String magazinename, String publicationdate, List<Writer> writers) {
		super();
		this.magazineid = magazineid;
		this.magazinename = magazinename;
		this.publicationdate = publicationdate;
		this.writers = writers;
	}
	public Magazine() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getMagazineid() {
		return magazineid;
	}
	public void setMagazineid(int magazineid) {
		this.magazineid = magazineid;
	}
	public String getMagazinename() {
		return magazinename;
	}
	public void setMagazinename(String magazinename) {
		this.magazinename = magazinename;
	}
	public String getPublicationdate() {
		return publicationdate;
	}
	public void setPublicationdate(String publicationdate) {
		this.publicationdate = publicationdate;
	}
	public List<Writer> getWriters() {
		return writers;
	}
	public void setWriters(List<Writer> writers) {
		this.writers = writers;
	}	

}
