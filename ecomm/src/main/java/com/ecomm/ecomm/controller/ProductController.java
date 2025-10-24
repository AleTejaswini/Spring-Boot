package com.ecomm.ecomm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ecomm.ecomm.common.Product;
import com.ecomm.ecomm.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping("/getall")
	public List<Product> getAll() {
		return productService.getAllProducts();
	}

	@GetMapping("/getbyid/{id}")
	public Product getById(@PathVariable int id) {
		return productService.getById(id);
	}
	
	@GetMapping("/getbyname/{name}")
	public List<Product> getbyname(@PathVariable String name) {
		return productService.getbyName(name);
	}

	@PostMapping("/addnewproduct")
	public Product addNew(@RequestBody Product p) {
		return productService.addProduct(p);
	}

	@PutMapping("/updateproduct/{id}")
	public Product updateProduct(@PathVariable int id, @RequestBody Product p) {
		return productService.updateProduct(id, p);
	}

	@DeleteMapping("/deletebyid/{productid}")
	public void deleteById(@PathVariable int productid) {
		productService.deleteById(productid);
	}

	@DeleteMapping("/deleteall")
	public void deleteAll() {
		productService.deleteAll();
	}
	
	@DeleteMapping("/deletebyprice/{productprice}")
	public void deletebyprice(@PathVariable double productprice) {
		productService.deleteByprice(productprice);
		
	}
	
	@DeleteMapping("/deletebyname/{productname}")
	public void deletebyname(@PathVariable String productname) {
		productService.deleteByProductname(productname);
	}
	
	@PatchMapping("/updatespecific/{id}")
	public Product updatespecific(@PathVariable int id ,@RequestBody Product p) {
		return productService.updatepatch(id, p);
	}
}
