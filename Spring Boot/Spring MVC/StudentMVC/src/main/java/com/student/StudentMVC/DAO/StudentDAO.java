package com.student.StudentMVC.DAO;

import java.util.ArrayList;
import java.util.List;

import com.student.StudentMVC.model.Student;

public class StudentDAO {

List<Student> list=new ArrayList<Student>();
	
	public void add(Student std) {
		 list.add(std);
	}
	
	
	public Student getstdbyid(int id) {
		for(Student s:list) {
			if(s.getStudentid()==id) {
				return s;
			}
	}
		return null;
	}
	
	
	public List<Student> getall(){
		return list;
	}
	
	public void delete(int id) {
		list.removeIf(e->e.getStudentid() ==id);
	}
}
