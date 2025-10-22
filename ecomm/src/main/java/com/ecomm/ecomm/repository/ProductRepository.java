package com.ecomm.ecomm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecomm.ecomm.common.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
