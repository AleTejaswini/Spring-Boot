package com.productcategory.shopease.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.productcategory.shopease.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer>{

}
