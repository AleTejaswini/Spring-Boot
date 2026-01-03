package com.aop.BankAOP.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aop.BankAOP.entity.Account;
import com.aop.BankAOP.service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {
	@Autowired
	private AccountService accountservice;
	
	@PostMapping("/addaccount")
	public Account addaccount(@RequestBody Account account) {
		return accountservice.addaccount(account);
	}
	
	@GetMapping("/getaccounts")
	public List<Account> getaccounts(){
		return accountservice.getaccounts();
	}
	
	@GetMapping("/getaccount/{id}")
	public Account getaccount(@PathVariable int id){
		return accountservice.getaccount(id);
	}
	
	@PutMapping("/deleteaccount")
	public String deleteaccount(@PathVariable int id){
		return accountservice.deleteaccount(id);
	}
}
