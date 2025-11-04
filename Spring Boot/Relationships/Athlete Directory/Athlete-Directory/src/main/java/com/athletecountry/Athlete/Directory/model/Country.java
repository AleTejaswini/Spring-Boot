package com.athletecountry.Athlete.Directory.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Country {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int countryid;
	private String countryname;
	public Country(int countryid, String countryname) {
		super();
		this.countryid = countryid;
		this.countryname = countryname;
	}
	public Country() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getCountryid() {
		return countryid;
	}
	public void setCountryid(int countryid) {
		this.countryid = countryid;
	}
	public String getCountryname() {
		return countryname;
	}
	public void setCountryname(String countryname) {
		this.countryname = countryname;
	}
	
	
}
