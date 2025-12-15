package com.transaction.Spring_Transaction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.transaction.Spring_Transaction.entity.Orders;
import com.transaction.Spring_Transaction.service.OrderProcessingService;

@RestController
@RequestMapping("/orders")
public class OrderProcessingController {
	@Autowired
	private  OrderProcessingService orderprocessingservice;

//	public OrderProcessingController(OrderProcessingService orderprocessingservice) {
//		super();
//		this.orderprocessingservice = orderprocessingservice;
//	}
	@PostMapping("/addorders")
	public ResponseEntity<?> placeOrder(@RequestBody Orders orders){
		return ResponseEntity.ok(orderprocessingservice.placeAnOrder(orders));
	}
}
