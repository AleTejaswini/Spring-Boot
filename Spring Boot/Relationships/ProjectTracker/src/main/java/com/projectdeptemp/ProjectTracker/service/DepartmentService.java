package com.projectdeptemp.ProjectTracker.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.projectdeptemp.ProjectTracker.model.Department;
import com.projectdeptemp.ProjectTracker.model.Employee;
import com.projectdeptemp.ProjectTracker.repository.DepartmentRepository;
import com.projectdeptemp.ProjectTracker.repository.EmployeeRepository;

@Service
public class DepartmentService {
	@Autowired
	private DepartmentRepository departmentrepository;
	
	@Autowired
	private EmployeeRepository employeerepository;
	
	public List<Department> getdepartments(){
		return departmentrepository.findAll();
	}
	
	public Department getdepartment(int deptid) {
		try {
		Department department =  departmentrepository.findById(deptid).get();
		return department;
	}
		catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"There is no department with id: "+deptid);
		}
}
	
	public Department adddepartment(Department department) {
		List<Integer> empids = new ArrayList<>();
		for(Employee emp : department.getEmployees()) {
			empids.add(emp.getEmpId());
		}
		
		List<Employee> completeemp = employeerepository.findAllById(empids);
		if(empids.size()!=completeemp.size()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"One or more emp ids are invalid");
		}
		department.setEmployees(completeemp);
		return departmentrepository.save(department);
	}
	
	
	public Department updatedepartment(int deptid,Department updateddepartment) {
		Department existingdepartment = departmentrepository.findById(deptid)
				.orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"There is no department with id: "+deptid));
		List<Integer> empids = new ArrayList<>();
		for(Employee emp : updateddepartment.getEmployees()) {
			empids.add(emp.getEmpId());
		}
		
		List<Employee> completeemp = employeerepository.findAllById(empids);
		if(empids.size()!=completeemp.size()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"One or more emp ids are invalid");
		}
		
		existingdepartment.setName(updateddepartment.getName());
		existingdepartment.setLocation(updateddepartment.getLocation());
		existingdepartment.setEmployees(completeemp);
		return departmentrepository.save(existingdepartment);
	}
	
	public void deletedepartment(int deptid) {
		Department department = departmentrepository.findById(deptid)
				.orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"There is no department with id: "+deptid));
		List<Integer> empids = new ArrayList<>();
		for(Employee emp : department.getEmployees()) {
			empids.add(emp.getEmpId());
		}
		
		 employeerepository.deleteAllById(empids);
		
		departmentrepository.delete(department);
	}
	
}