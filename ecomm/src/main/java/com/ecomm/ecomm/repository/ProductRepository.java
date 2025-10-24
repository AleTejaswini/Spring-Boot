package com.ecomm.ecomm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecomm.ecomm.common.Product;

import jakarta.transaction.Transactional;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	@Transactional
	Product deleteByProductname(String productname);
	
	@Transactional
	Product deleteByProductprice(double productprice);
	
	List<Product> findByProductname(String productname);
	
	
	
}
