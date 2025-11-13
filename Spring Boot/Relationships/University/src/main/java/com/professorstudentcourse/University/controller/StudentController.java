package com.professorstudentcourse.University.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.professorstudentcourse.University.model.Student;
import com.professorstudentcourse.University.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private StudentService studentservice;
	
	@GetMapping("/getstudent/{studentid}")
	public Student getstudent(@PathVariable int studentid) {
		return studentservice.getstudent(studentid);
	}
	
	@GetMapping("/getstudents")
	public List<Student> getstudents(){
		return studentservice.getstudents();
	}
	
	@PostMapping("/addstudent")
	public Student addstudent(@RequestBody Student student) {
		return studentservice.addstudent(student);
	}
	
	@PutMapping("/updatestudent/{studentid}")
	public Student updatestudent(@PathVariable int studentid,@RequestBody Student student) {
		return studentservice.updatestudent(studentid, student);
	}
	
	@DeleteMapping("/deletestudent/{studentid}")
	public Student  deletestudent(@PathVariable int studentid) {
		return studentservice.deletestudent(studentid);
	}
}
