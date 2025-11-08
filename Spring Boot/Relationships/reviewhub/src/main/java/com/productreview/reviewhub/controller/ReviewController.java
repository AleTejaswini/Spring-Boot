package com.productreview.reviewhub.controller;

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

import com.productreview.reviewhub.model.Review;
import com.productreview.reviewhub.service.ReviewService;

@RestController
@RequestMapping("/review")
public class ReviewController {

	@Autowired
	private ReviewService reviewservice;
	@GetMapping("/getreviews")
	public List<Review> getreviews(){
		return reviewservice.getreviews();
	}
	@GetMapping("/getreview/{reviewid}")
	public Review getreview(@PathVariable int reviewid){
		return reviewservice.getreview(reviewid);
	}
	
	@PostMapping("/addreview")
	public Review addreview(@RequestBody Review review){
		return reviewservice.addreview(review);
	}
	
	@PutMapping("/updatereview/{reviewid}")
	public Review updatereview(@PathVariable int reviewid,@RequestBody Review updatedreview){
		return reviewservice.updatereview(reviewid,updatedreview);
	}
	
	@DeleteMapping("/deletereview/{reviewid}")
	public void deletereview(@PathVariable int reviewid) {
		reviewservice.deletereview(reviewid);
	}
}
