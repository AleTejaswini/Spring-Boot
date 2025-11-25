package com.studentcourse.StudentCourseManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.studentcourse.StudentCourseManagement.model.Course;
import com.studentcourse.StudentCourseManagement.model.Student;
import com.studentcourse.StudentCourseManagement.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentservice;

	@PostMapping("/addstudent")
	public Student addstudent(@RequestBody Student student) {
		return studentservice.addStudent(student);
	}

	@PutMapping("/updatestudent/{id}")
	public Student updatestudent(@PathVariable int id, @RequestBody Student student) {
		return studentservice.updatestudent(id, student);
	}

	@GetMapping("/getstudent/{id}")
	public Student getstudent(@PathVariable int id) {
		return studentservice.getStudent(id);
	}

	@GetMapping("/getstudents")
	public List<Student> getstudents() {
		return studentservice.getStudents();
	}

	@DeleteMapping("/deletestudent/{id}")
	public String deletestudent(@PathVariable int id) {
		studentservice.deletestudent(id);
		return "Deleted Succesfully";
	}

//	derived query
	@GetMapping("/findByDepartment")
	public List<Student> findByDepartment(@RequestParam String department) {
		return studentservice.findByDepartment(department);
	}

//	Check whether email already exists.
	@GetMapping("/existsByEmail")
	public boolean existsByEmail(@RequestParam String email) {
		return studentservice.existsByEmail(email);
	}

//	Custom JPQL query
//	Get total credits of a student (sum).
	@GetMapping("/totalcreditsofstudent")
	public int totalcreditsofstudent(@RequestParam int stdId) {
		return studentservice.totalcreditsofstudent(stdId);
	}
}
