package com.professorstudentcourse.University.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.professorstudentcourse.University.model.Course;
import com.professorstudentcourse.University.model.Student;
import com.professorstudentcourse.University.repository.CourseRepository;
import com.professorstudentcourse.University.repository.StudentRespository;

@Service
public class StudentService {
	@Autowired
	private StudentRespository studentrepository;
	
	@Autowired
	private CourseRepository courserepository;
	
	public List<Student> getstudents(){
		return studentrepository.findAll();
	}
	
	public Student getstudent(int studentid) {
		try {
			Student student = studentrepository.findById(studentid).get();
			return student;
		}
		catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
	
	public Student addstudent(Student student) {
		List<Integer> courseids = new ArrayList<>();
		for(Course course:student.getCourses()) {
			courseids.add(course.getCourseId());
		}
		try {
			List<Course> completecourses= courserepository.findAllById(courseids);
			if(courseids.size()!=completecourses.size()) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"One or more course ids are invalid");
			}
			student.setCourses(completecourses);
			
			for(Course c:completecourses) {
				c.getStudents().add(student);
			}
			return studentrepository.save(student);
		}
		catch(NoSuchElementException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
	public Student updatestudent(int studentid,Student student) {
		try {
			Student newstudent = studentrepository.findById(studentid).get();
			if(student.getStudentName()!=null) {
				newstudent.setStudentName(student.getStudentName());
			}
			if(student.getEmail()!=null) {
				newstudent.setEmail(student.getEmail());
			}
			if(student.getCourses()!=null) {
				List<Course> courses= newstudent.getCourses();
				for(Course course:courses) {
					course.getStudents().remove(newstudent);
				}
			courserepository.saveAll(courses);
			List<Integer> courseids = new ArrayList<>(); 
			for(Course course:student.getCourses()) {
				courseids.add(course.getCourseId());
			}
			List<Course> completecourses= courserepository.findAllById(courseids);
			if(courseids.size()!=completecourses.size()) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"One or more course ids are invalid");
			}
			for(Course c:completecourses) {
				c.getStudents().add(newstudent);
			}
			courserepository.saveAll(completecourses);
			student.setCourses(completecourses);
			}
			return studentrepository.save(newstudent);
		}
		catch(NoSuchElementException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
	
	public Student deletestudent(int studentid) {
		try {
			Student student =studentrepository.findById(studentid).get();
			List<Course> courses = student.getCourses();
			for(Course course:courses) {
				course.getStudents().remove(student);
			}
			courserepository.saveAll(courses);
			studentrepository.deleteById(studentid);
		}
		catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        throw new ResponseStatusException(HttpStatus.NO_CONTENT);
	}
	
	
}
