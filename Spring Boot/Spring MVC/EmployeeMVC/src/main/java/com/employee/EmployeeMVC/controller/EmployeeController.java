package com.employee.EmployeeMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import com.employee.EmployeeMVC.dao.EmpDAO;
import com.employee.EmployeeMVC.model.Employee;
@Controller
public class EmployeeController {

	EmpDAO dao=new EmpDAO();
	
	@GetMapping("/")
	public String home(Model m) {
		m.addAttribute("employeelist" ,dao.getAll());
		return "home";
	}
	@GetMapping("/add")
	public String add() {
		return "add";
	}
	@PostMapping("/save")
	public String save(@ModelAttribute Employee e) {
		dao.add(e);
		return "redirect:/";
	}
	@GetMapping("/edit/{empid}")
	public String edit(@PathVariable int empid, Model m) {
		Employee e = dao.getById(empid);
		m.addAttribute("emp",e);
		return "edit";
	}
	@PostMapping("/update")			
	public String update(@ModelAttribute Employee e) {
		dao.update(e.getEmpid(), e);
		return "redirect:/";
	}
	@GetMapping("/delete/{empid}")
	public String delete(@PathVariable int empid) {
		dao.delete(empid);
		return "redirect:/";
	}
}
