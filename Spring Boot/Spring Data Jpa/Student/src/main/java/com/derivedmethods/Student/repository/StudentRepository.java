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
	
	//Ignorecase
	Student findByNameAndCityAllIgnoreCase(String name,String city);
	// Distinct 
	List<Student> findDistinctByCity(String city);
	//comparision operations
	List<Student> findByAgeGreaterThan(int age);
	List<Student> findByCityAndMarksBetween(String city,int marks1,int marks2);
	int countByAgeGreaterThanEqual(int age);
	List<Student> findByCityIn(List<String> city);
	List<Student> findByAgeBetween(int age1,int age2);
	
	
	// Pattern matching
	List<Student> findByEmailContaining(String keyword);
	
	
	// boolean check
	boolean existsByEmail(String email);
	
	// Limit queries
	Student findTop1ByMarksGreaterThan(int marks);
	Student findTop1ByOrderByMarksDesc();
	
	//sorting
	List<Student> findByAgeOrderByMarksDesc(int age);
	
	//logical operations
	List<Student> findByAgeAndCity(int age,String city);
	List<Student> findByAgeOrCity(int age,String city);
	
	List<Student> findByMarksGreaterThanAndEmailContaining(int marks,String keyword);
	// delete/remove
	void deleteByMarksLessThan(int marks);
	void removeByCity(String city);
	
	//pagination
	Page<Student> findByCity(String city,Pageable pageable);
	Page<Student> findAll(Pageable pageable);
	Page<Student> findByAgeAndCity(int age,String city,Pageable pageable);
	
	// isNull /isNotNull
	List<Student> findByCityIsNull();
	
	
	
	
	
	
	
	
	
	
	
	
}
