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
public class Event {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int eventid;
	private String eventname;
	private String date;
	
	@ManyToMany
	@JoinTable(name = "event_sponsor",
	joinColumns = @JoinColumn(name = "eventid"),
	inverseJoinColumns = @JoinColumn(name = "sponsorid"))
	@JsonIgnoreProperties("events")
	private List<Sponsor> sponsors = new ArrayList<>();

	public Event(int eventid, String eventname, String date, List<Sponsor> sponsors) {
		super();
		this.eventid = eventid;
		this.eventname = eventname;
		this.date = date;
		this.sponsors = sponsors;
	}

	public Event() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getEventid() {
		return eventid;
	}

	public void setEventid(int eventid) {
		this.eventid = eventid;
	}

	public String getEventname() {
		return eventname;
	}

	public void setEventname(String eventname) {
		this.eventname = eventname;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public List<Sponsor> getSponsors() {
		return sponsors;
	}

	public void setSponsors(List<Sponsor> sponsors) {
		this.sponsors = sponsors;
	}
	
	
	
	
}
