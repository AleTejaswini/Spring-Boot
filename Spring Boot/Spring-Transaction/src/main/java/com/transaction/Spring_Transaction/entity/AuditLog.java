package com.transaction.Spring_Transaction.entity;

import java.time.LocalDateTime;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class AuditLog {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private int orderid;
	private String action;
	private LocalDateTime timestamp;
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	public AuditLog(int orderid, String action, LocalDateTime timestamp) {
		super();
		this.orderid = orderid;
		this.action = action;
		this.timestamp = timestamp;
	}
	public AuditLog() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
