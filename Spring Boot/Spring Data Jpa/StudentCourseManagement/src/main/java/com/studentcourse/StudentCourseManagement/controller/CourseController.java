package com.studentcourse.StudentCourseManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
import com.studentcourse.StudentCourseManagement.service.CourseService;

@RestController
@RequestMapping("/course")
public class CourseController {

	@Autowired
	private CourseService courseservice;

	@PostMapping("/addcourse")
	public Course addcourse(@RequestBody Course course) {
		return courseservice.addCourse(course);
	}

	@GetMapping("/getcourse/{id}")
	public Course getcourse(@PathVariable int id) {
		return courseservice.getCourse(id);
	}

	@GetMapping("/getcourses")
	public List<Course> getcourses() {
		return courseservice.getCourses();
	}

	@PutMapping("/updatecourse/{id}")
	public Course updatecourse(@PathVariable int id, @RequestBody Course course) {
		return courseservice.updatecourse(id, course);
	}

	@DeleteMapping("/deletecourse/{id}")
	public String deletecourse(@PathVariable int id) {
		courseservice.deletecourse(id);

		return "Deleted Succesfully";
	}

	// derived query
	@GetMapping("/findByStudentStdId")
	public List<Course> findByStudentStdId(@RequestParam int stdId) {
		return courseservice.findByStudentStdId(stdId);
	}

//		Sorting
//		Get courses sorted by credits (DESC).
//		@GetMapping("/findAllbycreditsDesc")
//		public List<Course> findAll(Sort sort){
//			return courseservice.findAll(sort);
//		}

	// using input field
	@GetMapping("/findAll")
	public List<Course> findAll(@RequestParam String sortby, @RequestParam(defaultValue = "asc") String direction) {
		Sort sort = direction.equalsIgnoreCase("asc") ? Sort.by(sortby).ascending() : Sort.by(sortby).descending();
		return courseservice.findAll(sort);
	}

//	Pagination
//	Get paginated courses (5 per page).
	@GetMapping("/pagegetcourses")
	public Page<Course> getcourses(Pageable pageable) {
		return courseservice.getcourses(pageable);
	}

	// Sorting + Limit
	// Get top 3 latest added courses.
	@GetMapping("/findTop3ByOrderByCreditsAsc")
	public List<Course> findTop3ByOrderByCreditsAsc() {
		return courseservice.findTop3ByOrderByCreditsAsc();
	}

//	Get course list along with student name using JPQL  JOIN.
	@GetMapping("/getallcourses")
	public List<Course> getallcourses() {
		return courseservice.getallcourses();
	}

	// Update department of student using JPQL without loading entity.
//	JPQL Update
	@PutMapping("/updatecoursename")
	public int updatecoursename(@RequestParam int courseid, @RequestParam String coursename) {
		return courseservice.updatecoursename(courseid, coursename);
	}

//	Fetch type
//	Fetch Student and Courses in one query using JOIN FETCH (remove N+1).
	@GetMapping("/get")
	public List<Course> getcourse() {
		return courseservice.getcourse();
	}

//	Native Query
//Native SQL query to get top 5 courses with highest credits.
	@GetMapping("/gettop5")
	public List<Course> gettop5courses() {
		return courseservice.gettop5courses();
	}

//	JPQL Delete
//	Delete all courses of a student using JPQL.
	@DeleteMapping("/delete")
	public int deletecourses(@RequestParam int id) {
		return courseservice.deletecourses(id);
	}

}
