package com.professorstudentcourse.University.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.professorstudentcourse.University.model.Professor;
import com.professorstudentcourse.University.service.ProfessorService;

@RestController
@RequestMapping("/professor")
public class ProfessorController {

	@Autowired
	private ProfessorService professorservice;
	
	@GetMapping("/getprofessors")
	public List<Professor> getprofessors(){
		return professorservice.getprofessors();
	}
	
	@GetMapping("/getprofessor/{professorid}")
	public Professor getprofessor(@PathVariable int professorid) {
		return professorservice.getprofessor(professorid);
	}
	
	@PostMapping("/addprofessor")
	public Professor addprofessor(@RequestBody Professor professor) {
		return professorservice.addprofessor(professor);
	}
	
	
	@PutMapping("/updateprofessor/{professorid}")
	public Professor updateprofessor(@PathVariable int professorid,@RequestBody Professor professor) {
		return professorservice.updateprofessor(professorid,professor);
	}
	
	@DeleteMapping("/deleteprofessor/{professorid}")
	public void deleteprofessor(@PathVariable int professorid) {
		professorservice.deleteprofessor(professorid);
	}
	
}
