package com.derivedmethods.Student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.derivedmethods.Student.model.Student;
import com.derivedmethods.Student.repository.StudentRepository;
import com.derivedmethods.Student.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private StudentService studentservice;
	
	@Autowired
	private StudentRepository studentrepository;
	
	
	@PostMapping("/addstudent")
	public Student addstudent(@RequestBody Student student) {
		return studentservice.addstudent(student);
	}
	// select 
	@GetMapping("/findByName")
	public Student findbyname(@RequestParam String name) {
		return studentservice.findbyname(name);
	}
	
	@GetMapping("/getByCity")
	public List<Student> getbycity(@RequestParam String city) {
		return studentrepository.getByCity(city);
	}
	
	@GetMapping("/findByCity")
	public List<Student> findbycity(@RequestParam String city) {
		return studentrepository.findByCity(city);
	}
	
	
	//comparision operations
	@GetMapping("/findByAgeGreaterthan")
	public List<Student> findByAgeGreaterthan(@RequestParam int age) {
		return studentservice.findByAgeGreaterthan(age);
	}
	@GetMapping("/findByCityAndMarksBetween")
	public List<Student> findByCityAndMarksBetween(
			@RequestParam String city,
			@RequestParam int marks1,
			@RequestParam int marks2){
		if(marks1<marks2) {
		List<Student> students= studentrepository.findByCityAndMarksBetween(city, marks1, marks2);
		return students;
		}
		else {
			throw new RuntimeException("invalid marks, should be marks1<marks2");
		}
	}
	@GetMapping("/count")
	public int count(@RequestParam int age) {
		return studentrepository.countByAgeGreaterThanEqual(age);
	}
	
	@GetMapping("/findBycityIn")
	public List<Student> findBycityIn(@RequestParam List<String> city){
		return studentrepository.findByCityIn(city);
	}
	
	@GetMapping("/existsByEmail")
	public boolean existsByEmail(@RequestParam String email) {
		return studentrepository.existsByEmail(email);
		  
	}
	
	@GetMapping("/findbycity")
	public Page<Student> findByCity(@RequestParam String city,
			@RequestParam int pagenum,
			@RequestParam int size)
	{
		Pageable pageable = PageRequest.of(pagenum, size);
		Page<Student> page=studentrepository.findByCity(city,pageable);
		return page;
}
	
	
	@GetMapping("/find")
	public Page<Student> findall(
			@RequestParam int pagenum,
			@RequestParam int size,
			@RequestParam String sortby
			){
		Sort sort = Sort.by(sortby).ascending();
		Pageable pageable = PageRequest.of(pagenum, size, sort);
		Page<Student> page= studentrepository.findAll(pageable);
		return page;
	}
	
	
	
	
	
	@DeleteMapping("/deletestudent")
	public String deleteByMarksLessThan(@RequestParam int marks) {
		 studentservice.deletestudent(marks);
		 return "deleted";
	}
}
