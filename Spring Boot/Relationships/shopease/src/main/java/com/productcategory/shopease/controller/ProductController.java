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

import com.productcategory.shopease.model.Product;
import com.productcategory.shopease.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productservice;
	
	@GetMapping("/getproduct/{productid}")
	public Product getproduct(@PathVariable int productid) {
		return productservice.getproduct(productid);
	}
	
	@GetMapping("/getproducts")
	public List<Product> getproducts() {
		return productservice.getproducts();
	}
	
	@PostMapping("/addproduct")
	public Product addproduct(@RequestBody Product product) {
		return productservice.addproduct(product);
	}
	@PutMapping("/updateproduct/{productid}")
	public Product updateproduct(@PathVariable int productid,@RequestBody Product updatedproduct) {
		return productservice.updateproduct(productid,updatedproduct);
	}
	
	@DeleteMapping("/deleteproduct/{productid}")
	public void deleteproduct(@PathVariable int productid) {
		 productservice.deleteproduct(productid);
	}
	
	
}
