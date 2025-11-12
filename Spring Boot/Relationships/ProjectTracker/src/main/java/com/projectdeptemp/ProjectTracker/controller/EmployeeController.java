package com.projectdeptemp.ProjectTracker.controller;

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

import com.projectdeptemp.ProjectTracker.model.Department;
import com.projectdeptemp.ProjectTracker.model.Employee;
import com.projectdeptemp.ProjectTracker.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeservice;
	
	@GetMapping("/getemployee/{empid}")
	public Employee getemployee(@PathVariable int empid) {
		return employeeservice.getemployee(empid);
	}
	@GetMapping("/getemployees")
	public List<Employee> getemployees(){
		return employeeservice.getemployees();
	}
	
	@PostMapping("/addemployee")
	public Employee addemployee(@RequestBody Employee employee) {
		return employeeservice.addemployee(employee);
	}
	
	@PutMapping("/updateemployee/{empid}")
	public Employee updateemployee(@PathVariable int empid,@RequestBody Employee updateemployee) {
		return employeeservice.updateemployee(empid, updateemployee);
	}
	
	@DeleteMapping("/deleteemployee/{empid}")
	public void deleteemployee(@PathVariable int empid) {
		employeeservice.deleteemployee(empid);
	}
	
}
