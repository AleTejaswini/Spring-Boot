package com.transaction.Spring_Transaction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.transaction.Spring_Transaction.entity.Orders;
import com.transaction.Spring_Transaction.entity.Product;
import com.transaction.Spring_Transaction.handler.AuditLogHandler;
import com.transaction.Spring_Transaction.handler.InventoryHandler;
import com.transaction.Spring_Transaction.handler.NotificationHandler;
import com.transaction.Spring_Transaction.handler.OrderHandler;
import com.transaction.Spring_Transaction.handler.PaymentHandler;
import com.transaction.Spring_Transaction.handler.ProductRecommendationHandler;
import com.transaction.Spring_Transaction.repository.AuditLogRepository;



@Service
public class OrderProcessingService {
	@Autowired
	private  OrderHandler orderhandler;
	@Autowired
	private  InventoryHandler inventoryhandler;
	@Autowired
	private  PaymentHandler paymenthandler;
	@Autowired
	private  AuditLogHandler auditloghandler;
	
	@Autowired
	private  ProductRecommendationHandler productrecommendationhandler;
	
	@Autowired
	private  NotificationHandler notificationhandler;
	
	public OrderProcessingService(OrderHandler orderhandler, InventoryHandler inventoryhandler) {
		super();
		this.orderhandler = orderhandler;
		this.inventoryhandler = inventoryhandler;
	}
	@Transactional(propagation = Propagation.REQUIRED)
	public Orders placeAnOrder(Orders orders) {
		Product product =inventoryhandler.getProduct(orders.getProductid());
		
	//validate stock availability <5
		validatestockavailability(orders,product);
	//update total price in entity
	orders.setTotalprice(orders.getQuantity()*product.getPrice());
	//save order
	
	Orders saveorders = null;
	try {
		saveorders = orderhandler.saveOrders(orders);		
		//update stock in inventory
		updateInventoryStock(orders,product);
		auditloghandler.logauditdetails(orders, "Orders placement succecced");
	} catch (Exception e) {
		auditloghandler.logauditdetails(orders, "Orders placement failed");
	}
	
//	paymenthandler.validatepayment(orders);
//	notificationhandler.sendOrderConfiramtion(orders);
//	productrecommendationhandler.getrecommendations();
	getcustomerdetails();
	return saveorders;
	}
	
	
	private void updateInventoryStock(Orders orders,Product product) {
		int availablestock=product.getStockQuantity() - orders.getQuantity();
		product.setStockQuantity(availablestock);
		inventoryhandler.Updateproduct(product);
	}
	
	private static void validatestockavailability(Orders orders,Product product) {
		if(orders.getQuantity()>product.getStockQuantity()) {
			throw new RuntimeException("Out od stock");
		}
	}
	@Transactional(propagation=Propagation.SUPPORTS)
	public void getcustomerdetails() {
		System.out.println("Customer details fetched");
	}
	
}
