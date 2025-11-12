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
import com.projectdeptemp.ProjectTracker.service.DepartmentService;


@RestController
@RequestMapping("/department")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentservice;
	
	@GetMapping("/getdepartment/{deptid}")
	public Department getdepartment(@PathVariable int deptid) {
		return departmentservice.getdepartment(deptid);
	}
	@GetMapping("/getdepartments")
	public List<Department> getdepartments(){
		return departmentservice.getdepartments();
	}
	
	@PostMapping("/adddepartment")
	public Department adddepartment(@RequestBody Department department) {
		return departmentservice.adddepartment(department);
	}
	
	@PutMapping("/updatedepartment/{deptid}")
	public Department updatedepartment(@PathVariable int deptid,@RequestBody Department updatedepartment) {
		return departmentservice.updatedepartment(deptid, updatedepartment);
	}
	
	@DeleteMapping("/deletedepartment/{deptid}")
	public void deletedepartment(@PathVariable int deptid) {
		 departmentservice.deletedepartment(deptid);
	}

}