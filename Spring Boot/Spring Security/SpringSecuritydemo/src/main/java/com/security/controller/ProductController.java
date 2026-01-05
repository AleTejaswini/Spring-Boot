package com.security.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
@RestController
public class ProductController {

	private record Product(Integer productId,String Productname,double price) {}
		
	List<Product> products = new ArrayList<>(
	List.of(new Product(1,"Mac",50000),
			new Product(2,"Linux",40000))
	);
	
	@GetMapping("/csrf")
	public CsrfToken gettoken(HttpServletRequest request) {
		return (CsrfToken) request.getAttribute("_csrf");
		
	}
	@GetMapping("/get")
	public List<Product> getproducts(){
		return products;
	}
	
	@PostMapping("/addproduct")
	public Product addproduct(@RequestBody Product product) {
		products.add(product);
		return product;
	}
	
}
