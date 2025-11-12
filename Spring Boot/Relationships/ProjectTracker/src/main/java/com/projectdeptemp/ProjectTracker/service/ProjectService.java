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

@Service
public class ProjectService {
	@Autowired
	private ProjectRepository projectrepository;
	
	@Autowired
	private EmployeeRepository employeerepository;
	
	public List<Project> getprojects(){
		return projectrepository.findAll();
	}
	
	public Project getproject(int projectid) {
		Project project = projectrepository.findById(projectid)
				.orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"There is no project with id: "+projectid));
		return project;
	}
	
	public Project addproject(Project project) {
		List<Integer> empids = new ArrayList<>();
		for(Employee emp : project.getEmployees()) {
			empids.add(emp.getEmpId());
		}
		
		List<Employee> completeemp = employeerepository.findAllById(empids);
		if(empids.size()!= completeemp.size()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"One or more emp ids are invalid");
		}
		project.setEmployees(completeemp);
		for(Employee e:completeemp) {
			e.getProjects().add(project);
		}
		return projectrepository.save(project);
	}
	
	
	public Project updateproject(int projectid,Project updatedproject) {
		Project existingproject = projectrepository.findById(projectid)
				.orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"There is no project with id: "+projectid));
		existingproject.setName(updatedproject.getName());
		existingproject.setStartdate(updatedproject.getStartdate());
		existingproject.setEnddate(updatedproject.getEnddate());
		List<Integer> empids = new ArrayList<>();
		for(Employee emp : updatedproject.getEmployees()) {
			empids.add(emp.getEmpId());
		}
		
		List<Employee> completeemp = employeerepository.findAllById(empids);
		if(empids.size()!= completeemp.size()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"One or more emp ids are invalid");
		}
		existingproject.setEmployees(completeemp);
		for(Employee e:completeemp) {
			e.getProjects().add(existingproject);
		}
		
		return projectrepository.save(existingproject);
	}
	
	public void deleteproject(int projectid) {
		Project project = projectrepository.findById(projectid)
				.orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"There is no project with id: "+projectid));
		project.setEmployees(null);
		projectrepository.delete(project);
	}
	
}
