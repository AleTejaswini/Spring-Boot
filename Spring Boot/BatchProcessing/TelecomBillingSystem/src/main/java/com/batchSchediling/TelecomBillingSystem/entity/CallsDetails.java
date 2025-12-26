package com.batchSchediling.TelecomBillingSystem.entity;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "calls_details")
public class CallsDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String mobilenum;
	 @Column(name = "call_date")
	    private LocalDate callDate;
	public int total_duration;
	private int incoming_call_count;
	private int outgoing_call_count;
	private double total_bill_amount;
	
	
	
	public String getMobilenum() {
		return mobilenum;
	}
	public void setMobilenum(String mobilenum) {
		this.mobilenum = mobilenum;
	}
	
	
	public LocalDate getCallDate() {
		return callDate;
	}
	public void setCallDate(LocalDate callDate) {
		this.callDate = callDate;
	}
	public int getTotal_duration() {
		return total_duration;
	}
	public void setTotal_duration(int total_duration) {
		this.total_duration = total_duration;
	}
	public int getIncoming_call_count() {
		return incoming_call_count;
	}
	public void setIncoming_call_count(int incoming_call_count) {
		this.incoming_call_count = incoming_call_count;
	}
	public int getOutgoing_call_count() {
		return outgoing_call_count;
	}
	public void setOutgoing_call_count(int outgoing_call_count) {
		this.outgoing_call_count = outgoing_call_count;
	}
	public double getTotal_bill_amount() {
		return total_bill_amount;
	}
	public void setTotal_bill_amount(double total_bill_amount) {
		this.total_bill_amount = total_bill_amount;
	}
	public CallsDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	

}
