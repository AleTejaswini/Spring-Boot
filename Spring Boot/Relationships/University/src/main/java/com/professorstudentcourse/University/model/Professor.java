package com.professorstudentcourse.University.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Professor {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int professorId;	
	private String professorName;	
	private String department;
	public Professor() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getProfessorId() {
		return professorId;
	}
	public void setProfessorId(int professorId) {
		this.professorId = professorId;
	}
	public String getProfessorName() {
		return professorName;
	}
	public void setProfessorName(String professorName) {
		this.professorName = professorName;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}	
	

}
