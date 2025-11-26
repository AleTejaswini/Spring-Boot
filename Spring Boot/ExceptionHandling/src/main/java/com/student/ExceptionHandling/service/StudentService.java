package com.student.ExceptionHandling.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.student.ExceptionHandling.Exceptions.DuplicateStudentException;
import com.student.ExceptionHandling.model.Student;
import com.student.ExceptionHandling.repository.StudentRespository;

@Service
public class StudentService {

	@Autowired
	private StudentRespository studentrepository;
	
	public Student addstudent(Student student) {
		List<Student> names =studentrepository.findByName(student.getName());
		if(names !=null) {
			throw new DuplicateStudentException("Student with name " +student.getName() + " exists");
		}
		return studentrepository.save(student);
	}
	
	public Student getstudent(int id) {
		return studentrepository.findById(id)
				.orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"No student with id:" +id));
	}
}
