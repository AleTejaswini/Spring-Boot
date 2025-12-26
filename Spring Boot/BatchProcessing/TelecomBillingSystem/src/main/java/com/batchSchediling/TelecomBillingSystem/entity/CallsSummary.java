package com.batchSchediling.TelecomBillingSystem.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;



@Entity
public class CallsSummary {
	@Id
	private int id;
	private String mobilenum;
    private String call_type;
    private int total_duration;
    private LocalDate call_date;
	public String getMobilenum() {
		return mobilenum;
	}
	public void setMobilenum(String mobilenum) {
		this.mobilenum = mobilenum;
	}
	public String getCall_type() {
		return call_type;
	}
	public void setCall_type(String call_type) {
		this.call_type = call_type;
	}
	public int getTotal_duration() {
		return total_duration;
	}
	public void setTotal_duration(int total_duration) {
		this.total_duration = total_duration;
	}
	public LocalDate getCall_date() {
		return call_date;
	}
	public void setCall_date(LocalDate call_date) {
		this.call_date = call_date;
	}
	public CallsSummary() {
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
