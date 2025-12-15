package com.transaction.Spring_Transaction.handler;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.transaction.Spring_Transaction.entity.AuditLog;
import com.transaction.Spring_Transaction.entity.Orders;
import com.transaction.Spring_Transaction.repository.AuditLogRepository;
@Service
public class AuditLogHandler {
	@Autowired
	private AuditLogRepository auditlogrepository;
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void logauditdetails(Orders orders,String action) {
		AuditLog auditlog =new AuditLog();
		auditlog.setAction(action);
		auditlog.setOrderid(orders.getOrderid());;
		auditlog.setTimestamp(LocalDateTime.now());
		auditlogrepository.save(auditlog);
	}
}
