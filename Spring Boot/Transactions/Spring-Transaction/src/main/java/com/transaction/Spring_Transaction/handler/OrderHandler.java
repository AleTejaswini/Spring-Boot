package com.transaction.Spring_Transaction.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.transaction.Spring_Transaction.entity.Orders;
import com.transaction.Spring_Transaction.repository.OrdersRepository;
@Service
public class OrderHandler {
	
	@Autowired
	private final OrdersRepository ordersrepository;
	
	public OrderHandler(OrdersRepository ordersrepository) {
		this.ordersrepository=ordersrepository;
	}
	@Transactional(propagation = Propagation.REQUIRED)
	public Orders saveOrders(Orders orders) {
		return ordersrepository.save(orders);
	}
	
	
}
