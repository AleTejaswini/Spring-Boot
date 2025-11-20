package com.derivedmethods.Student.service;

import java.util.List;

import org.hibernate.query.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Sort;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import com.derivedmethods.Student.model.Student;
import com.derivedmethods.Student.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	private  StudentRepository studentrepository;
	
	public Student addstudent(Student student) {
		return studentrepository.save(student);
	}
	
	
	public Student findbyname(String name) {
		try {
		Student student=	studentrepository.findByName(name);
		return student;
		}
		catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"There is student with name: "+name);
		}
		 
	}
	
	public List<Student> findByAgeGreaterthan(int age) {
		try {
		List<Student> students= studentrepository.findByAgeGreaterThan(age);
		return students;
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"There is student greaterthan age: "+age);
		}
	}
	
	@Transactional
	public void deletestudent(int marks){
	studentrepository.deleteByMarksLessThan(marks);
	}
	@Transactional
	public void removeByCity(String city) {
		studentrepository.removeByCity(city);
	}
}
