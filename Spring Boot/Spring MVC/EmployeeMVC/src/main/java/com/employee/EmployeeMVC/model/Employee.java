package com.employee.EmployeeMVC.model;

public class Employee {

	private int empid;
	private String empname;
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public Employee(int empid, String empname) {
		super();
		this.empid = empid;
		this.empname = empname;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
