package com.transaction.Spring_Transaction.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.transaction.Spring_Transaction.entity.Product;
import com.transaction.Spring_Transaction.repository.InventoryRepository;
@Service
public class InventoryHandler {
	@Autowired
	private  InventoryRepository inventoryrepository;
	@Transactional(propagation = Propagation.REQUIRED)
	public Product Updateproduct(Product product) {
		if(product.getPrice()>5000) {
			throw new RuntimeException("DB crashed");
		}
		return inventoryrepository.save(product);
	}
	
	public Product getProduct(int id) {
		return inventoryrepository.findById(id)
				.orElseThrow(()->new RuntimeException("Product with "+id+ " not found"));
	}
}
