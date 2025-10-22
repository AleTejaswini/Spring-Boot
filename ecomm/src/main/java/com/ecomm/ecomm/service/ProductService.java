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
	public Product getById(int id) {
		return productRepository.findById(id).orElse(null);
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

	// Delete all products
	public void deleteAll() {
		productRepository.deleteAll();
	}
}
