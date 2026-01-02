package com.aop.AOPEmployee.model;

public class Employee {
	
	private int EmpId;
	private String firstname;
	private String lastname;
	public int getEmpId() {
		return EmpId;
	}
	public void setEmpId(int empId) {
		EmpId = empId;
	}
	public String getFirstname() {
		return firstname;
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
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
