package com.derivedmethods.Student.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.derivedmethods.Student.model.Student;
@Repository
public interface StudentRepository extends JpaRepository<Student,Integer>{

	// select
	Student findByName(String name);
	List<Student> getByCity(String city);
	List<Student> findByCity(String city);
	
	//comparision operations
	List<Student> findByAgeGreaterThan(int age);
	List<Student> findByCityAndMarksBetween(String city,int marks1,int marks2);
	int countByAgeGreaterThanEqual(int age);
	List<Student> findByCityIn(List<String> city);
	
	boolean existsByEmail(String email);
	
	Page<Student> findByCity(String city,Pageable pageable);
	
	
	
	
	Page<Student> findAll(Pageable pageable);
	
	
	
	void deleteByMarksLessThan(int marks);
	
	
}
