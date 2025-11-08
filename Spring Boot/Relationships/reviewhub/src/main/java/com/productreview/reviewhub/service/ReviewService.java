package com.productreview.reviewhub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.productreview.reviewhub.model.Review;
import com.productreview.reviewhub.repository.ReviewRepository;

@Service
public class ReviewService {
	@Autowired
	private ReviewRepository reviewrepository;
	
	public List<Review> getreviews(){
		return reviewrepository.findAll();
	}
	
	public Review getreview(int reviewid) {
		try {
			Review review =reviewrepository.findById(reviewid).get();
			return review;
		}
		catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"There is no review with id : "+reviewid);
		}
	}
	
	public Review addreview(Review review) {
		
		return reviewrepository.save(review);
	}
	
	public Review updatereview(int reviewid,Review updatedreview) {
		Review existingreview=reviewrepository.findById(reviewid)
				.orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"There isno review with id: "+reviewid));
		existingreview.setReviewcontent(updatedreview.getReviewcontent());
		existingreview.setRating(updatedreview.getRating());
		return reviewrepository.save(existingreview);
		
		
						
	}
	
	public void deletereview(int reviewid) {
		Review review = reviewrepository.findById(reviewid)
				.orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"There isno review with id: "+reviewid));
		reviewrepository.delete(review);
	}
	
}
