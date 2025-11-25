package com.studentcourse.StudentCourseManagement.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.studentcourse.StudentCourseManagement.model.Course;
import com.studentcourse.StudentCourseManagement.model.Student;

import jakarta.transaction.Transactional;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

	List<Course> findByStudent(Student student);

	// Get all courses for a particular student using derived query.
	List<Course> findByStudentStdId(int stdId);

//	Sorting
//	Get courses sorted by credits (DESC).
//	List<Course> findAll(Sort sort);

	// using input custom field
	List<Course> findAll(Sort sort);

//Sorting + Limit
//Get top 3 latest added courses.
	List<Course> findTop3ByOrderByCreditsAsc();

//	Get course list along with student name using JPQL  JOIN.
	@Query("select c from Course c join c.student s")
	List<Course> getallcourses();

//Update department of student using JPQL without loading entity.
//	JPQL Update
	@Transactional
	@Modifying
	@Query("update Course c  set  c.courseName = :coursename   where c.CourseId = :id")
	int updatecoursename(@Param("id") int courseid, @Param("coursename") String coursename);

//	Fetch type
//	Fetch Student and Courses in one query using JOIN FETCH (remove N+1).
	@Query("select c from Course c join fetch  c.student s")
	List<Course> getcourse();

//	Native Query
//	Native SQL query to get top 5 courses with highest credits.
	@Query(value = "select * from Course c order by c.credits desc limit 5", nativeQuery = true)
	List<Course> gettop5courses();

//	JPQL Delete
//	Delete all courses of a student using JPQL.
	@Transactional
	@Modifying
	@Query("delete from Course c where c.CourseId = :id")
	int deletecourses(@Param("id") int id);

}
