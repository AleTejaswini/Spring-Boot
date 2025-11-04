package com.sponsorevent.Event.Management.System.model;

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
public class Sponsor {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int sponsorid;
	
	private String sponsorname;
	private String industry;
	
	@ManyToMany(mappedBy = "sponsors")
	@JsonIgnoreProperties("sponsors")
	private List<Event> events = new ArrayList<>();

	public Sponsor(int sponsorid, String sponsorname, String industry, List<Event> events) {
		super();
		this.sponsorid = sponsorid;
		this.sponsorname = sponsorname;
		this.industry = industry;
		this.events = events;
	}

	public Sponsor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getSponsorid() {
		return sponsorid;
	}

	public void setSponsorid(int sponsorid) {
		this.sponsorid = sponsorid;
	}

	public String getSponsorname() {
		return sponsorname;
	}

	public void setSponsorname(String sponsorname) {
		this.sponsorname = sponsorname;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}
	
	
}
