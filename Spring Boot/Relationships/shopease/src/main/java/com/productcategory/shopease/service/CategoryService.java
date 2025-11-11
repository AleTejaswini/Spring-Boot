package com.productcategory.shopease.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.productcategory.shopease.model.Category;
import com.productcategory.shopease.model.Product;
import com.productcategory.shopease.repository.CategoryRepository;
import com.productcategory.shopease.repository.ProductRepository;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository categoryrepository;
	@Autowired
	private ProductRepository productrepository;
	
	
	public List<Category> getcategories(){
		return categoryrepository.findAll();
	}
	
	public Category getcategory(int categoryid){
		try {
			Category category = categoryrepository.findById(categoryid).get();
			return category;
		}
		catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"There is no product with id: "+categoryid);
		}
	}
	
	
	public Category addcategory(Category category) {
		List<Integer> productids = new ArrayList<>();
		for(Product product:category.getProducts() ) {
			productids.add(product.getProductid());
		}
		List<Product> completeproducts = productrepository.findAllById(productids);
		if(productids.size()!=completeproducts.size()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"One or more product ids are invalid");
		}
		category.setProducts(completeproducts);
		
		return categoryrepository.save(category);
	}
	
	public Category updatecategory(int categoryid,Category updatedcategory) {
		try {
			Category existingcategory = categoryrepository.findById(categoryid).get();
			
			
			List<Integer> productids = new ArrayList<>();
			for(Product product:updatedcategory.getProducts() ) {
				productids.add(product.getProductid());
			}
			List<Product> completeproducts = productrepository.findAllById(productids);
			if(productids.size()!=completeproducts.size()) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"One or more product ids are invalid");
			}
			existingcategory.setName(updatedcategory.getName());
			existingcategory.setDescription(updatedcategory.getDescription());
			existingcategory.setProducts(completeproducts);
			
			return categoryrepository.save(existingcategory);
		}
		catch(NoSuchElementException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"There is no product with id: "+categoryid);
		}
	}
	
	public void deletecategory(int categoryid) {
		Category category = categoryrepository.findById(categoryid)
				.orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"There is no product with id: "+categoryid));
		List<Integer> productids = new ArrayList<>();
		for(Product product:category.getProducts() ) {
			productids.add(product.getProductid());
		}
		List<Product> completeproducts = productrepository.findAllById(productids);
		productrepository.deleteAll(completeproducts);
		categoryrepository.delete(category);
	}
}
