package com.productcategory.shopease.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.productcategory.shopease.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer>{

}
