package com.writermagazine.Storyhub.controller;

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

import com.writermagazine.Storyhub.model.Writer;
import com.writermagazine.Storyhub.service.WriterService;

@RestController
@RequestMapping("/writer")
public class WriterController {
	
	@Autowired
	private WriterService writerservice;
	
	@GetMapping("/getwriter")
	public List<Writer> getwriters(){
		return writerservice.getwriters();
	}
	
	@GetMapping("/getwriter/{writerid}")
	public Writer getwriter(@PathVariable int writerid) {
		return writerservice.getwriter(writerid);
	}
	
	@PostMapping("/addwriter")
	public Writer addwriter(@RequestBody Writer writer) {
		return writerservice.addwriter(writer);
	}
	
	@PutMapping("/updatewriter/{writerid}")
	public Writer updatewriter(@PathVariable int writerid ,@RequestBody Writer updatedwriter) {
		return writerservice.updatewriter(writerid, updatedwriter);
	}
	
	@DeleteMapping("/deletewriter/{writerid}")
	public void deletewriter(@PathVariable int writerid) {
		writerservice.deletewriter(writerid);
	}
}
