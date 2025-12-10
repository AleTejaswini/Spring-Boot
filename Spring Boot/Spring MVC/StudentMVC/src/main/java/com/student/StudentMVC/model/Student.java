package com.student.StudentMVC.model;

public class Student {

	private int studentid;
	private String studentname;
	public int getStudentid() {
		return studentid;
	}
	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}
	public String getStudentname() {
		return studentname;
	}
	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}
	public Student(int studentid, String studentname) {
		super();
		this.studentid = studentid;
		this.studentname = studentname;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
