package com.reservation.RailwayReservation.model;

public class Reservation {

	private String firstname;
	private String lastname;
	private String gender;
	private String[] food;
	private String cityFrom;
	private String cityTo;
	public Reservation(String firstname, String lastname, String gender, String[] food, String cityFrom,
			String cityTo) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.gender = gender;
		this.food = food;
		this.cityFrom = cityFrom;
		this.cityTo = cityTo;
	}
	public String getCityFrom() {
		return cityFrom;
	}
	public void setCityFrom(String cityFrom) {
		this.cityFrom = cityFrom;
	}
	public String getCityTo() {
		return cityTo;
	}
	public void setCityTo(String cityTo) {
		this.cityTo = cityTo;
	}
	public String getFirstname() {
		return firstname;
	}
	public String[] getFood() {
		return food;
	}
	public void setFood(String[] food) {
		this.food = food;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	
	public Reservation() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
