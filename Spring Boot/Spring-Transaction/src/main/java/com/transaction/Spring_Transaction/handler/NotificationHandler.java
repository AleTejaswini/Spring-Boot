package com.transaction.Spring_Transaction.handler;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.transaction.Spring_Transaction.entity.Orders;

@Service
public class NotificationHandler {
	@Transactional(propagation=Propagation.NEVER)
	public void sendOrderConfiramtion(Orders order) {
		System.out.println(order.getOrderid() +"Order placed successfully");
	}
}
