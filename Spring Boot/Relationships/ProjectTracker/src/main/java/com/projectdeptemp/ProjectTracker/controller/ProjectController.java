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

import com.projectdeptemp.ProjectTracker.model.Project;
import com.projectdeptemp.ProjectTracker.service.ProjectService;

@RestController
@RequestMapping("/project")
public class ProjectController {
	@Autowired
	private ProjectService projectservice;
	@GetMapping("/getproject/{projectid}")
	public Project getproject(@PathVariable int projectid) {
		return projectservice.getproject(projectid);
	}
	
	@GetMapping("/getprojects")
	public List<Project> getprojects() {
		return projectservice.getprojects();
	}
	
	@PostMapping("/addproject")
	public Project addproject(@RequestBody Project project) {
		return projectservice.addproject(project);
	}
	
	@PutMapping("/updateproject/{projectid}")
	public Project updateproject(@PathVariable int projectid,@RequestBody Project updateproject) {
		return projectservice.updateproject(projectid, updateproject);
	}

	@DeleteMapping("/deleteproject/{projectid}")
	public void deleteproject(@PathVariable int projectid) {
		projectservice.deleteproject(projectid);
	}
}
