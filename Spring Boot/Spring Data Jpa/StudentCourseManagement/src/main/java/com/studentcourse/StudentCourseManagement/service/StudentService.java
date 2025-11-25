package com.studentcourse.StudentCourseManagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import com.studentcourse.StudentCourseManagement.model.Course;
import com.studentcourse.StudentCourseManagement.model.Student;
import com.studentcourse.StudentCourseManagement.repository.CourseRepository;
import com.studentcourse.StudentCourseManagement.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	private StudentRepository studentrepository;
	@Autowired
	private CourseRepository courserepository;

	public Student addStudent(Student student) {
		return studentrepository.save(student);
	}

	public Student getStudent(int id) {
		Student student = studentrepository.findById(id).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "There is no Student with id:" + id));
		return student;
	}

	public List<Student> getStudents() {
		List<Student> students = studentrepository.findAll();
		return students;
	}

	public Student updatestudent(int id, Student updatedstudent) {
		Student existingstudent = studentrepository.findById(id).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "There is no student with id: " + id));
		existingstudent.setName(updatedstudent.getName());
		existingstudent.setEmail(updatedstudent.getEmail());
		existingstudent.setDepartment(updatedstudent.getDepartment());
		studentrepository.save(existingstudent);
		return existingstudent;
	}

	public String deletestudent(int id) {
		Student student = studentrepository.findById(id).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "There is no student with id: " + id));

		List<Course> courses = courserepository.findByStudent(student);
		for (Course course : courses) {
			course.setStudent(null);
		}
		courserepository.saveAll(courses);
		studentrepository.delete(student);
		return "Deleted succesfully";
	}

//	derived query
	public List<Student> findByDepartment(String department) {
		return studentrepository.findByDepartment(department);
	}

//	Check whether email already exists.
	public boolean existsByEmail(String email) {
		return studentrepository.existsByEmail(email);
	}

//	Custom JPQL query
//	Get total credits of a student (sum).
	public int totalcreditsofstudent(int stdId) {
		return studentrepository.totalcreditsofstudent(stdId);
	}
}
