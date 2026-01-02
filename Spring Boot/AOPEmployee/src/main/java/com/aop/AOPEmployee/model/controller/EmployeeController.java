package com.aop.AOPEmployee.model.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aop.AOPEmployee.model.Employee;
import com.aop.AOPEmployee.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService employeeservice;
	
	@GetMapping("/createemp")
	public Employee createemployee(@RequestParam int empid,@RequestParam String firstname,@RequestParam String lastname) {
		return employeeservice.createemployee(empid, firstname, lastname);
	}
	
	@GetMapping("/deleteemp")
	public String  deleteemp(@RequestParam int empid) {
		employeeservice.deleteemployee(empid);
		return "deleted successfully";
	}
	
}
