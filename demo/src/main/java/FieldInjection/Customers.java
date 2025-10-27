package FieldInjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class Customers {
	private int custid;
	private String custname;
	private String coursename;
	@Autowired
	private Technologies techid;
	
	public Technologies getTechid() {
		return techid;
	}
	public void setTechid(Technologies techid) {
		this.techid = techid;
	}
	public int getCustid() {
		return custid;
	}
	public void setCustid(int custid) {
		this.custid = custid;
	}
	public String getCustname() {
		return custname;
	}
	public void setCustname(String custname) {
		this.custname = custname;
	}
	public String getCoursename() {
		return coursename;
	}
	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}
	
	public void display() {
		System.out.println("Object created successfully");
		techid.show();
	}
}
