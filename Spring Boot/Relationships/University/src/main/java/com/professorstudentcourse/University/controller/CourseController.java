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

import com.professorstudentcourse.University.model.Course;
import com.professorstudentcourse.University.service.CourseService;

@RestController
@RequestMapping("/course")
public class CourseController {

	@Autowired
	private CourseService courseservice;
	
	@GetMapping("/getcourses")
	public List<Course> getcourses(){
		return courseservice.getcourses();
	}
	
	@GetMapping("/getcourse/{courseid}")
	public Course getcourse(@PathVariable int courseid) {
		return courseservice.getcourse(courseid);
	}
	
	@PostMapping("/addcourse")
	public Course addcourse(@RequestBody Course course) {
		return courseservice.addcourse(course);
	}
	
	
	@PutMapping("/updatecourse/{courseid}")
	public Course updatecourse(@PathVariable int courseid,@RequestBody Course course) {
		return courseservice.updatecourse(courseid,course);
	}
	
	@DeleteMapping("/deletecourse/{courseid}")
	public void deletecourse(@PathVariable int courseid) {
		 courseservice.deletecourse(courseid);
	}
	
	
}
