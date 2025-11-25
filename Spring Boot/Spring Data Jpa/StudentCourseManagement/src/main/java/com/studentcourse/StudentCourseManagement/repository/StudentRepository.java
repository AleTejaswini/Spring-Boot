package com.studentcourse.StudentCourseManagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.studentcourse.StudentCourseManagement.model.Course;
import com.studentcourse.StudentCourseManagement.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

	// Get all students from "CSE" department.
	List<Student> findByDepartment(String department);

//	Check whether email already exists.
	boolean existsByEmail(String email);

//	Custom JPQL query
//	Get total credits of a student (sum).
	@Query("select sum(c.credits) from Course c join c.student s where s.stdId = :stdId")
	int totalcreditsofstudent(@Param("stdId") int stdId);

}
