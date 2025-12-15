package com.transaction.Spring_Transaction.handler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.transaction.Spring_Transaction.entity.Product;

@Service
public class ProductRecommendationHandler {
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<Product> getrecommendations(){
		List<Product> recommendations = new ArrayList<>();
		
		recommendations.add(new Product(101,"Wireless headphones",9000,10));
		recommendations.add(new Product(102,"SmartPhone case",3000,10));
		recommendations.add(new Product(103,"Bluetooth Speaker",5500,10));
		recommendations.add(new Product(104,"Gaming mouse",500,10));
		
	System.out.println("recommendations fetch for customer");
	
	return recommendations;
		
		
	}
}
