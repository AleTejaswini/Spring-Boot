package com.projectdeptemp.ProjectTracker.model;


import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;


@Entity
public class Employee { //many
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int EmpId;
	private String name;
	private String email;
	
	@ManyToMany(cascade= CascadeType.ALL, mappedBy="employees")
	@JsonIgnoreProperties("employees")
	private List<Project> projects=new ArrayList<>();
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public List<Project> getProjects() {
		return projects;
	}
	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
	public int getEmpId() {
		return EmpId;
	}
	public void setEmpId(int empId) {
		EmpId = empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	

	
	
}
