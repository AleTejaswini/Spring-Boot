package com.bookpublisher.relationship.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Publisher {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int publisherid;
	private String publishername;
	public Publisher(int publisherid, String publishername) {
		super();
		this.publisherid = publisherid;
		this.publishername = publishername;
	}
	public Publisher() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getPublisherid() {
		return publisherid;
	}
	public void setPublisherid(int publisherid) {
		this.publisherid = publisherid;
	}
	public String getPublishername() {
		return publishername;
	}
	public void setPublishername(String publishername) {
		this.publishername = publishername;
	}
	
	
}
