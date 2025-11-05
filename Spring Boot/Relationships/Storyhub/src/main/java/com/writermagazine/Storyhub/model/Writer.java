package com.writermagazine.Storyhub.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
@Entity
public class Writer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int writerid;	
	private String writername;	
	private String bio;	
	
	@ManyToMany
	@JoinTable(
	name = "writer_magazine",
	joinColumns = @JoinColumn(name = "writerid"),
	inverseJoinColumns = @JoinColumn(name = "magazineid"))
	@JsonIgnoreProperties("writers")
	private List<Magazine> magazines = new ArrayList<>();
	
	
	public Writer(int writerid, String writername, String bio, List<Magazine> magazines) {
		super();
		this.writerid = writerid;
		this.writername = writername;
		this.bio = bio;
		this.magazines = magazines;
	}
	public Writer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getWriterid() {
		return writerid;
	}
	public void setWriterid(int writerid) {
		this.writerid = writerid;
	}
	public String getWritername() {
		return writername;
	}
	public void setWritername(String writername) {
		this.writername = writername;
	}
	public String getBio() {
		return bio;
	}
	public void setBio(String bio) {
		this.bio = bio;
	}
	public List<Magazine> getMagazines() {
		return magazines;
	}
	public void setMagazines(List<Magazine> magazines) {
		this.magazines = magazines;
	}
	
	

}
