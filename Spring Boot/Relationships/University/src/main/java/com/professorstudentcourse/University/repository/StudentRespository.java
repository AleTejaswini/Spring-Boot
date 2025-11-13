package com.professorstudentcourse.University.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.professorstudentcourse.University.model.Student;

@Repository
public interface StudentRespository extends JpaRepository<Student,Integer>{

}
