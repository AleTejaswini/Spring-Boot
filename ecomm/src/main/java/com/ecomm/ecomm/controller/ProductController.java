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

	@PostMapping("/addnewproduct")
	public Product addNew(@RequestBody Product p) {
		return productService.addProduct(p);
	}

	@PutMapping("/updateproduct/{id}")
	public Product updateProduct(@PathVariable int id, @RequestBody Product p) {
		return productService.updateProduct(id, p);
	}

	@DeleteMapping("/deletebyid/{id}")
	public void deleteById(@PathVariable int id) {
		productService.deleteById(id);
	}

	@DeleteMapping("/deleteall")
	public void deleteAll() {
		productService.deleteAll();
	}
}
