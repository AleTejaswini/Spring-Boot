package com.student.StudentMVC.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.student.StudentMVC.DAO.StudentDAO;
import com.student.StudentMVC.model.Student;

@Controller
public class StudentController {
	
	StudentDAO dao = new StudentDAO();
	
	@GetMapping("/add")
	public String Hello(Model m ) {
		m.addAttribute("stdlist", dao.getall());
		return "add";
	}
	
	@PostMapping("/save")
	public String add(@ModelAttribute Student std,Model m) {
		dao.add(std);
		m.addAttribute("stdlist", dao.getall());
		return "result";
	}
	
	@GetMapping("/delete/{stdid}")
	public String deleteall(@PathVariable int stdid ) {
		dao.delete(stdid);
		return "delete";
		
	}
	
	@GetMapping("/getall")
	public String getall(Model m) {
	m.addAttribute("stdlist", dao.getall());
	return "result";
	}
}
