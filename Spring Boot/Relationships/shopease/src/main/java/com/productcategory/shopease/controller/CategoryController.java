package com.productcategory.shopease.controller;

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

import com.productcategory.shopease.model.Category;
import com.productcategory.shopease.service.CategoryService;


@RestController
@RequestMapping("/category")
public class CategoryController {
	@Autowired
	private CategoryService categoryservice;
	
	@GetMapping("/getcategory/{categoryid}")
	public Category getcategory(@PathVariable int categoryid) {
		return categoryservice.getcategory(categoryid);
	}
	
	@GetMapping("/getcategories")
	public List<Category> getcategories() {
		return categoryservice.getcategories();
	}
	
	@PostMapping("/addcategory")
	public Category addcategory(@RequestBody Category category) {
		return categoryservice.addcategory(category);
	}
	
	@PutMapping("/updatecategory/{categoryid}")
	public Category updatecategory(@PathVariable int categoryid,@RequestBody Category updatecategory) {
		return categoryservice.updatecategory(categoryid,updatecategory);
	}
	@DeleteMapping("/deletecategory/{categoryid}")
	public void deletecategory(@PathVariable int categoryid) {
		 categoryservice.deletecategory(categoryid);
	}
}
