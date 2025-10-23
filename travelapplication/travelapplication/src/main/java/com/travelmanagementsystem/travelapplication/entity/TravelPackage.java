package com.travelmanagementsystem.travelapplication.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class TravelPackage {
	@Id
	private int packageid;
	private String destination;
	private int hoursduration;
	private double price;
	private boolean availability;
	public TravelPackage(int packageid, String destination, int hoursduration, double price, boolean availability) {
		super();
		this.packageid = packageid;
		this.destination = destination;
		this.hoursduration = hoursduration;
		this.price = price;
		this.availability = availability;
	}
	public TravelPackage() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getPackageid() {
		return packageid;
	}
	public void setPackageid(int packageid) {
		this.packageid = packageid;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public int getHoursduration() {
		return hoursduration;
	}
	public void setHoursduration(int hoursduration) {
		this.hoursduration = hoursduration;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public boolean getAvailability() {
		return availability;
	}
	public void setAvailability(boolean availability) {
		this.availability = availability;
	}
	
	

}
