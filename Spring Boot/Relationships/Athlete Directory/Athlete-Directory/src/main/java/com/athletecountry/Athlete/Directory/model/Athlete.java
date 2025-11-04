package com.athletecountry.Athlete.Directory.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Athlete {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int athleteid;
	private String name;
	private String sport;
	
	@ManyToOne
	@JoinColumn(name = "countryid")
	private Country country;

	public Athlete(int athleteid, String name, String sport, Country country) {
		super();
		this.athleteid = athleteid;
		this.name = name;
		this.sport = sport;
		this.country = country;
	}

	public Athlete() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getAthleteid() {
		return athleteid;
	}

	public void setAthleteid(int athleteid) {
		this.athleteid = athleteid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSport() {
		return sport;
	}

	public void setSport(String sport) {
		this.sport = sport;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}
	
	
	
	
}
