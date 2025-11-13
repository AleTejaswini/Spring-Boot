package com.professorstudentcourse.University.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.professorstudentcourse.University.model.Course;
import com.professorstudentcourse.University.model.Professor;
import com.professorstudentcourse.University.model.Student;
import com.professorstudentcourse.University.repository.CourseRepository;
import com.professorstudentcourse.University.repository.ProfessorRespository;
import com.professorstudentcourse.University.repository.StudentRespository;

@Service
public class CourseService {
	@Autowired
	private CourseRepository courserepository;
	
	@Autowired
	private ProfessorRespository professorrepository;
	
	@Autowired
	private StudentRespository studentrepository;
	
	public List<Course> getcourses(){
		return courserepository.findAll();
	}
	
	public Course getcourse(int courseid) {
		try {
			Course course = courserepository.findById(courseid).get();
			return course;
		}
		catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
	
	public Course addcourse(Course course) {
		List<Integer> studentids = new ArrayList<>();
		for(Student student:course.getStudents()) {
			studentids.add(student.getStudentId());
		}
		try {
		Professor professor= course.getProfessor();
		int professorid =professor.getProfessorId();
		Professor completeprofessor =professorrepository.findById(professorid).get();
		course.setProfessor(completeprofessor);
		
		
		List<Student> completestudents = studentrepository.findAllById(studentids);
		if(studentids.size()!=completestudents.size()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"One or more student ids are invalid");
		}
		course.setStudents(completestudents);
		for(Student s :completestudents) {
			s.getCourses().add(course);
		}
		Course savedcourse=courserepository.save(course);
		studentrepository.saveAll(completestudents);
		
		return savedcourse;
		}
		catch(NoSuchElementException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}}
	
	public Course updatecourse(int courseid , Course updatedcourse) {
		try {
		Course existingcourse = courserepository.findById(courseid).get();
		if(updatedcourse.getCourseName()!=null) {
			existingcourse.setCourseName(updatedcourse.getCourseName());
		}
		if(updatedcourse.getCredits()!=0) {
			existingcourse.setCredits(updatedcourse.getCredits());
		}
		if(updatedcourse.getProfessor()!=null) {
			int professorid = updatedcourse.getProfessor().getProfessorId();
			Professor professor = professorrepository.findById(professorid).get();
			existingcourse.setProfessor(professor);
		}
		if(updatedcourse.getStudents()!=null) {
			List<Student> students = existingcourse.getStudents();
			for(Student student:students) {
				student.getCourses().remove(existingcourse);
			}
			studentrepository.saveAll(students);
			List<Integer> studentids = new ArrayList<>();
			for(Student student:updatedcourse.getStudents()) {
				studentids.add(student.getStudentId());
			}
			List<Student> completestudents = studentrepository.findAllById(studentids);
			if(studentids.size()!=completestudents.size()) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"One or more student ids are invalid");
			}
			
			for(Student s :completestudents) {
				s.getCourses().add(existingcourse);
			}
			
			studentrepository.saveAll(completestudents);
			existingcourse.setStudents(completestudents);
			
	
		}
		return courserepository.save(existingcourse);
	}catch(NoSuchElementException e) {
		throw new ResponseStatusException(HttpStatus.NOT_FOUND);
	}
}
	
	public void deletecourse(int courseid) {
		try {
			Course course = courserepository.findById(courseid).get();
			List<Student> students= course.getStudents();
			for(Student student:students) {
				student.getCourses().remove(course);
			}
			studentrepository.saveAll(students);
			courserepository.deleteById(courseid);
		}
		catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		throw new ResponseStatusException(HttpStatus.NO_CONTENT);
	}
}
