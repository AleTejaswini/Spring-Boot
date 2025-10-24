package com.ecomm.ecomm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecomm.ecomm.common.Product;
import com.ecomm.ecomm.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	// Add a new product
	public Product addProduct(Product p) {
		return productRepository.save(p);
	}

	// Get all products
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	// Get product by ID
	public Product getById(int productid) {
		return productRepository.findById(productid).orElseThrow(()->new RuntimeException("Not found"));
	}
	
	// Get product by Name
	public List<Product> getbyName(String productname){
		return productRepository.findByProductname(productname);
	}

	// Update existing product
	public Product updateProduct(int id, Product updated) {
		Product existing = productRepository.findById(id).orElse(null);
		if (existing == null) {
			return null;
		}

		existing.setProductname(updated.getProductname());
		existing.setProductprice(updated.getProductprice());
		existing.setProductquantity(updated.getProductquantity());
		return productRepository.save(existing);
	}

	// Delete product by ID
	public void deleteById(int id) {
		productRepository.deleteById(id);
	}
	
	// Delete product by price
	public void deleteByprice(double productprice) {
		productRepository.deleteByProductprice(productprice);
	}
	
	// Delete product by Name
	public void deleteByProductname(String productname ) {
		productRepository.deleteByProductname(productname);
	}

	// Delete all products
	public void deleteAll() {
		productRepository.deleteAll();
	}
	
	
	//update existing product specific value
	public Product updatepatch(int id ,Product p) {
		Product existing = productRepository.findById(id).orElseThrow(()->new RuntimeException ("Product not found"));
		String n = p.getProductname();
		Double pr =p.getProductprice();
		Integer q = p.getProductquantity();
		if(n != null) {
			existing.setProductname(p.getProductname());}
		 if(pr !=null && pr>0)
			existing.setProductprice(p.getProductprice());
		if (q !=null && q>0)
			existing.setProductquantity(p.getProductquantity());
		return productRepository.save(existing);
	}
	
}
