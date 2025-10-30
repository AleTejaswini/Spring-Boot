package com.chefrestaurant.DineMaster.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Restaurant {
	@Id
	private int id;
	private String name;
	private String address;
	private String cusineType;
	private int rating;
	public Restaurant(int id, String name, String address, String cusineType, int rating) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.cusineType = cusineType;
		this.rating = rating;
	}
	public Restaurant() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCusineType() {
		return cusineType;
	}
	public void setCusineType(String cusineType) {
		this.cusineType = cusineType;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	
	
}
