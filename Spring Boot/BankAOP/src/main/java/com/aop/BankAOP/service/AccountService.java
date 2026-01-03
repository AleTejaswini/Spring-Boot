package com.aop.BankAOP.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aop.BankAOP.entity.Account;
import com.aop.BankAOP.entity.respository.AccountRepository;

@Service
public class AccountService {
	@Autowired
	private AccountRepository accountrepository;
	
	public Account addaccount(Account account) {
		if(account.getId()<=0) {
			throw new RuntimeException("Invalid id"); 
		}
		accountrepository.save(account);
		return  account;
	}
	
	public List<Account> getaccounts() {
		List<Account> accounts = accountrepository.findAll();
		return accounts;
	}
	
	public Account getaccount(int id) {
		Account account = accountrepository.findById(id)
				.orElseThrow(()->  new RuntimeException("Not found"));
		return account;
	}
	
	public String deleteaccount(int id) {
		Account account = accountrepository.findById(id)
				.orElseThrow(()->new RuntimeException("Not found"));
		accountrepository.delete(account);
		return "Account with "+id+" deleted successfully";
	}
	
	
	
}
