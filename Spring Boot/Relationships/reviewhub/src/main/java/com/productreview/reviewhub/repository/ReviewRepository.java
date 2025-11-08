package com.productreview.reviewhub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.productreview.reviewhub.model.Review;
@Repository
public interface ReviewRepository extends JpaRepository<Review,Integer>{

}
