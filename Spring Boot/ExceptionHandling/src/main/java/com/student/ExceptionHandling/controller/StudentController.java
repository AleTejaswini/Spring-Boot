package com.student.ExceptionHandling.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.student.ExceptionHandling.Exceptions.StudentNotFound;
import com.student.ExceptionHandling.model.Student;
import com.student.ExceptionHandling.repository.StudentRespository;
import com.student.ExceptionHandling.service.StudentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/std")
public class StudentController {
	@Autowired
	private StudentService studentservice;
	
	@Autowired
	private StudentRespository studentrepository;
	
	@PostMapping("/addstudent")
	public Student addstudent(@Valid @RequestBody Student student) {
		return studentservice.addstudent(student);
	}
	
	@GetMapping("/getstudent")
	public Student getstudent(@RequestParam int id) {
		if(id<=0) {
			throw new IllegalArgumentException("Invalid id");
		}
		return studentservice.getstudent(id);
	}
	@ExceptionHandler
	public ResponseEntity<String> handleIAE(IllegalArgumentException ex){
		return ResponseEntity.badRequest().body(ex.getMessage());
	}
	
	@GetMapping("/findbyname")
	public List<Student> findbyname( @RequestParam String name){
		if(!studentrepository.existsByName(name)) {
			throw new StudentNotFound("Student not found with name :"+name);
		}
		return studentrepository.findByName(name);
	}
}
