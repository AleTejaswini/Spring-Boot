package com.productcategory.shopease.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.productcategory.shopease.model.Product;
import com.productcategory.shopease.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productrepository;
	
	public List<Product> getproducts(){
		return productrepository.findAll();
	}
	
	public Product getproduct(int productid){
		try {
			Product product = productrepository.findById(productid).get();
			return product;
		}
		catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"There is no product with id: "+productid);
		}
	}
	
	
	public Product addproduct(Product product) {
		return productrepository.save(product);
	}
	
	
	public Product updateproduct(int productid,Product updatedproduct) {
		try {
			Product existingproduct = productrepository.findById(productid).get();
			existingproduct.setProductname(updatedproduct.getProductname());
			existingproduct.setDescription(updatedproduct.getDescription());
			return productrepository.save(existingproduct);
		}
		catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"There is no product with id: "+productid);
		}
	}
	
	
	public void deleteproduct(int productid) {
		Product product =productrepository.findById(productid)
				.orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"There is no product with id: "+productid));
		
		productrepository.delete(product);
	}
}
