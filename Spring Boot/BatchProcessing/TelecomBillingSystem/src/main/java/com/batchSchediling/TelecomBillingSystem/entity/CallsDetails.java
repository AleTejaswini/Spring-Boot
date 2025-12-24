package com.batchSchediling.TelecomBillingSystem.entity;

import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class CallsDetails {
	@Id
	private int id;
	private String mobilenum;
	private LocalDate  call_date;
	public int total_duration;
	private int incoming_call_count;
	private int outgoing_call_count;
	private double total_bill_amount;
	private String call_type;
	public String getCall_type() {
		return call_type;
	}
	public void setCall_type(String call_type) {
		this.call_type = call_type;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMobilenum() {
		return mobilenum;
	}
	public void setMobilenum(String mobilenum) {
		this.mobilenum = mobilenum;
	}
	
	public LocalDate getCall_date() {
		return call_date;
	}
	public void setCall_date(LocalDate call_date) {
		this.call_date = call_date;
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
	public CallsSummary() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
