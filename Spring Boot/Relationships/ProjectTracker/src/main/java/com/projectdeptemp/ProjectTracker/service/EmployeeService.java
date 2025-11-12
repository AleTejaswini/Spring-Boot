package com.projectdeptemp.ProjectTracker.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.projectdeptemp.ProjectTracker.model.Employee;
import com.projectdeptemp.ProjectTracker.model.Project;
import com.projectdeptemp.ProjectTracker.repository.EmployeeRepository;
import com.projectdeptemp.ProjectTracker.repository.ProjectRepository;

import jakarta.transaction.Transactional;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeerepository;
	
	@Autowired
	private ProjectRepository projecterepository;
	
	public List<Employee> getemployees(){
		return employeerepository.findAll();
	}
	
	public Employee getemployee(int empid) {
		try {
			Employee employee =employeerepository.findById(empid).get();
			return employee;
		}
		catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"There is no employee with id: "+empid);
		}
	}
	
	public Employee addemployee(Employee employee) {
		List<Integer> projectids = new ArrayList<>();
		for(Project project : employee.getProjects()) {
			projectids.add(project.getProjectid());
		}
		List<Project> completeproject = projecterepository.findAllById(projectids);
		if(projectids.size()!= completeproject.size()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"One or more project ids are invalid");
		}
		
		employee.setProjects(completeproject);
		for(Project p : completeproject) {
			p.getEmployees().add(employee);
		}
		return employeerepository.save(employee);
	}
	
	public Employee updateemployee(int empid,Employee updatedemployee) {
		Employee existingemployee = employeerepository.findById(empid)
				.orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"There is no employee with id: "+empid));
		existingemployee.setName(updatedemployee.getName());
		existingemployee.setEmail(updatedemployee.getEmail());
		List<Integer> projectids = new ArrayList<>();
		for(Project project : updatedemployee.getProjects()) {
			projectids.add(project.getProjectid());
		}
		List<Project> completeproject = projecterepository.findAllById(projectids);
		if(projectids.size()!= completeproject.size()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"One or more project ids are invalid");
		}
		
		existingemployee.setProjects(completeproject);
		for(Project p : completeproject) {
			p.getEmployees().add(existingemployee);
		}
		return employeerepository.save(existingemployee);
	}
	
	
	
	public void deleteemployee(int empid) {
		Employee employee = employeerepository.findById(empid)
				.orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"There is no employee with id: "+empid));
		List<Project> projects = employee.getProjects();
		projecterepository.deleteAll(projects);
		employeerepository.delete(employee);
	}
	
}
