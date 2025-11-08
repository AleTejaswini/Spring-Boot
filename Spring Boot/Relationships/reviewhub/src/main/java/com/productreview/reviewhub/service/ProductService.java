package com.productreview.reviewhub.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.productreview.reviewhub.model.Product;
import com.productreview.reviewhub.model.Review;
import com.productreview.reviewhub.repository.ProductRepository;
import com.productreview.reviewhub.repository.ReviewRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productrepository;
	
	@Autowired
	private ReviewRepository reviewrepository;
	
	public List<Product> getproducts(){
		return productrepository.findAll();
	}
	
	public Product getproduct(int productid) {
		try {
			Product product =productrepository.findById(productid).get();
			return product;
		}
		catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"There is no product with id : "+productid);
		}
	}
	
	
	public Product addproduct(Product product) {
	return productrepository.save(product);
	}
	
	public Product updateproduct(int productid,Product updatedproduct) {
			Product existingproduct = productrepository.findById(productid)
					.orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"There isno product with id: "+productid));
			existingproduct.setProductname(updatedproduct.getProductname());
			existingproduct.setPrice(updatedproduct.getPrice());
			List<Integer> reviewids = new ArrayList<>();
			for(Review review:updatedproduct.getReviews()) {
				reviewids.add(review.getReviewid());
				
			}
			List<Review> completereviews= reviewrepository.findAllById(reviewids);
			if(reviewids.size()!=completereviews.size()) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"One or more review ids are invalid");
			}
			
			existingproduct.setReviews(completereviews);
			return productrepository.save(existingproduct);
}
	
	public void deleteproduct(int productid) {
		Product product = productrepository.findById(productid)
				.orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"There isno product with id: "+productid));
		List<Review> reviews = product.getReviews();
		reviewrepository.deleteAll(reviews);
		productrepository.deleteById(productid);
	}
}
