package com.student.ExceptionHandling.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.student.ExceptionHandling.model.Student;

@Repository
public interface StudentRespository extends JpaRepository<Student,Integer>{

	List<Student> findByName(String name);
	
	boolean existsByName(String name);
}
