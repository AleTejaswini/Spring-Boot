package com.professorstudentcourse.University.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.professorstudentcourse.University.model.Professor;

@Repository
public interface ProfessorRespository extends JpaRepository<Professor,Integer> {

}
