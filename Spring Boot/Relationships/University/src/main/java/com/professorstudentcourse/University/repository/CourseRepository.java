package com.professorstudentcourse.University.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.professorstudentcourse.University.model.Course;
import com.professorstudentcourse.University.model.Professor;
@Repository
public interface CourseRepository extends JpaRepository<Course,Integer>{

	List<Course> findByProfessor(Professor professor);
}
