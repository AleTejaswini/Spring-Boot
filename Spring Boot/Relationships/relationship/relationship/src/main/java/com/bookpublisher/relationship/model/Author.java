package com.bookpublisher.relationship.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Author {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int authorid;
	private String authorname;
	
	@ManyToMany(mappedBy ="authors")
	@JsonIgnoreProperties("authors")
	private List<Book> books = new ArrayList<>();
	public int getAuthorid() {
		return authorid;
	}
	public void setAuthorid(int authorid) {
		this.authorid = authorid;
	}
	public String getAuthorname() {
		return authorname;
	}
	public void setAuthorname(String authorname) {
		this.authorname = authorname;
	}
	public Author(int authorid, String authorname,List<Book> books) {
		super();
		this.authorid = authorid;
		this.authorname = authorname;
		this.books =books;
	}
	public Author() {
		super();
		// TODO Auto-generated constructor stub
	}
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
	
}
