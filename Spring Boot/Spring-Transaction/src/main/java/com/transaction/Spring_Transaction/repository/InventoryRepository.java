package com.transaction.Spring_Transaction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.transaction.Spring_Transaction.entity.Product;
@Repository
public interface InventoryRepository extends JpaRepository<Product,Integer> {

}
