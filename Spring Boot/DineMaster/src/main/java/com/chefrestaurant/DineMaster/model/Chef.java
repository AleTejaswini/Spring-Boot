package com.chefrestaurant.DineMaster.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Chef {
	@Id
	private int id;
	private String firstName;
	private String lastName;
	private String expertise;
	private int experienceYears;
	@ManyToOne
	@JoinColumn(name = "restaurantId")
	private Restaurant restaurant;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getExpertise() {
		return expertise;
	}
	public void setExpertise(String expertise) {
		this.expertise = expertise;
	}
	public int getExperienceYears() {
		return experienceYears;
	}
	public void setExperienceYears(int experienceYears) {
		this.experienceYears = experienceYears;
	}
	public Restaurant getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	public Chef(int id, String firstName, String lastName, String expertise, int experienceYears,
			Restaurant restaurant) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.expertise = expertise;
		this.experienceYears = experienceYears;
		this.restaurant = restaurant;
	}
	public Chef() {
		super();
		// TODO Auto-generated constructor stub
	}

}
