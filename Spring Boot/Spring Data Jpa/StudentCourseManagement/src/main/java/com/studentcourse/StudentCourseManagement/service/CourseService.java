package com.studentcourse.StudentCourseManagement.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.studentcourse.StudentCourseManagement.model.Course;
import com.studentcourse.StudentCourseManagement.model.Student;
import com.studentcourse.StudentCourseManagement.repository.CourseRepository;
import com.studentcourse.StudentCourseManagement.repository.StudentRepository;

@Service
public class CourseService {

	@Autowired
	private CourseRepository courserepository;

	@Autowired
	private StudentRepository studentrepository;

	public Course addCourse(Course course) {
		Student student = course.getStudent();
		int studentid = student.getStdId();
		Student completestudent = studentrepository.findById(studentid).get();
		course.setStudent(completestudent);
		return courserepository.save(course);
	}

	public Course getCourse(int id) {
		Course course = courserepository.findById(id).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "There is no Course with id:" + id));
		return course;
	}

	public List<Course> getCourses() {
		List<Course> courses = courserepository.findAll();
		return courses;
	}

	public Course updatecourse(int courseid, Course updatedcourse) {

		Course existingcourse = courserepository.findById(courseid).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "There is no course with id:" + courseid));
		existingcourse.setCourseName(updatedcourse.getCourseName());
		existingcourse.setCredits(updatedcourse.getCredits());
		Student student = updatedcourse.getStudent();
		int studentid = student.getStdId();
		Student completestudent = studentrepository.findById(studentid)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid studentid"));
		existingcourse.setStudent(completestudent);
		studentrepository.save(completestudent);
		return courserepository.save(existingcourse);
	}

	public String deletecourse(int courseid) {
		Course course = courserepository.findById(courseid).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "There is no course with id:" + courseid));
		courserepository.delete(course);
		return "deleted successfully";
	}

	// derived query
	public List<Course> findByStudentStdId(int stdId) {
		return courserepository.findByStudentStdId(stdId);
	}

//		Sorting
//		Get courses sorted by credits (DESC).
//		public List<Course> findAll(Sort sort){
//			Sort sortby = Sort.by("credits").descending();
//			return courserepository.findAll(sortby);
//	}

	// using input field
	public List<Course> findAll(Sort sort) {

		return courserepository.findAll(sort);

	}

//		Pagination
//		Get paginated courses (5 per page).
	public Page<Course> getcourses(Pageable pageable) {
		Pageable pagerequest = PageRequest.of(0, 5);
		return courserepository.findAll(pagerequest);

	}

	// Sorting + Limit
	// Get top 3 latest added courses.
	public List<Course> findTop3ByOrderByCreditsAsc() {
		return courserepository.findTop3ByOrderByCreditsAsc();
	}

//		Get course list along with student name using JPQL  JOIN.
	public List<Course> getallcourses() {
		return courserepository.getallcourses();
	}

	// Update department of student using JPQL without loading entity.
//		JPQL Update
	public int updatecoursename(int courseid, String coursename) {
		return courserepository.updatecoursename(courseid, coursename);
	}

//		Fetch type
//		Fetch Student and Courses in one query using JOIN FETCH (remove N+1).
	public List<Course> getcourse() {
		return courserepository.getcourse();
	}

//			Native Query
//		Native SQL query to get top 5 courses with highest credits.
	public List<Course> gettop5courses() {
		return courserepository.gettop5courses();
	}

//		JPQL Delete
//		Delete all courses of a student using JPQL.
	public int deletecourses(int id) {
		return courserepository.deletecourses(id);
	}

}
