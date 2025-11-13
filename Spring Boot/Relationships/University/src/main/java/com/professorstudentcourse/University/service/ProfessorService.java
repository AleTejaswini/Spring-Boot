package com.professorstudentcourse.University.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.professorstudentcourse.University.model.Course;
import com.professorstudentcourse.University.model.Professor;
import com.professorstudentcourse.University.repository.ProfessorRespository;
import com.professorstudentcourse.University.repository.CourseRepository;
@Service
public class ProfessorService {
	
	@Autowired
	private ProfessorRespository professorrespository;
	
	@Autowired
	private CourseRepository courserespository;
	
	public Professor getprofessor(int professorid) {
		try {
			Professor professor = professorrespository.findById(professorid).get();
			return professor;
		}
		catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
	
	public List<Professor> getprofessors(){
		return professorrespository.findAll();
	}
	
	public Professor addprofessor(Professor professor) {
		return professorrespository.save(professor);
	}
	
	public Professor updateprofessor(int professorid, Professor professor) {
		try {
			Professor newprofessor = professorrespository.findById(professorid).get();
			if(professor.getProfessorName()!=null) {
				newprofessor.setProfessorName(professor.getProfessorName());
			}
			
			if(professor.getDepartment()!=null) {
				newprofessor.setDepartment(professor.getDepartment());
			}
			return professorrespository.save(newprofessor);
		}
		catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		
	}
	
	public void deleteprofessor(int professorid) {
		try {
			Professor professor = professorrespository.findById(professorid).get();
			List<Course> courses = courserespository.findByProfessor(professor);
			for(Course course:courses) {
				course.setProfessor(null);
			}
			courserespository.saveAll(courses);
			professorrespository.deleteById(professorid);
		}
		catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
}
