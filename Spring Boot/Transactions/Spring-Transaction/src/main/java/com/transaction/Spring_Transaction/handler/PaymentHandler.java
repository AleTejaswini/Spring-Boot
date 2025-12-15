package com.transaction.Spring_Transaction.handler;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.transaction.Spring_Transaction.entity.AuditLog;
import com.transaction.Spring_Transaction.entity.Orders;
import com.transaction.Spring_Transaction.repository.AuditLogRepository;

@Service
public class PaymentHandler {

	private AuditLogRepository  auditlogrepository;
	@Transactional(propagation=Propagation.MANDATORY)
	public void validatepayment(Orders order) {
		boolean PaymentSuccessfull= false;
		if(!PaymentSuccessfull) {
			AuditLog paymentfailurelog = new AuditLog();
			paymentfailurelog.setOrderid(order.getOrderid());
			paymentfailurelog.setAction("Payment order failed for orders");
			paymentfailurelog.setTimestamp(LocalDateTime.now());
		
		
//		if(order.getTotalprice()>1000) {
//			throw new RuntimeException("Error in payment validator");
//		}
		
		auditlogrepository.save(paymentfailurelog);
	}}
}
