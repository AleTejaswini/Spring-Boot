package com.transaction.BankProject.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Account {
	@Id
	private String AccountNo;
	private double balance;
	private int totalcredits;
	private int totaldebits;
	public String getAccountNo() {
		return AccountNo;
	}
	public void setAccountNo(String accountNo) {
		AccountNo = accountNo;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public int getTotalcredits() {
		return totalcredits;
	}
	public void setTotalcredits(int totalcredits) {
		this.totalcredits = totalcredits;
	}
	public int getTotaldebits() {
		return totaldebits;
	}
	public void setTotaldebits(int totaldebits) {
		this.totaldebits = totaldebits;
	}
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
