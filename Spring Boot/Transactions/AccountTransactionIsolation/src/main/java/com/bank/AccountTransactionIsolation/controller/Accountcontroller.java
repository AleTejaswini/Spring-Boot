package com.bank.AccountTransactionIsolation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.AccountTransactionIsolation.entity.Account;
import com.bank.AccountTransactionIsolation.service.AccountService;

@RestController
@RequestMapping("/account")
public class Accountcontroller {
	@Autowired
	private AccountService accountservice;

	@PutMapping("/debitdelay/{id}/{amount}")
	public String debitdelay(@PathVariable Long id, @PathVariable int amount) {
		accountservice.debitwithdelay(id, amount);
		return "debit request completed";
	}

	@GetMapping("/getaccount/{id}")
	public Account getaccount(@PathVariable Long id) {
		return accountservice.getaccount(id);
	}

	@GetMapping("/repeatableread/{id}")
	public String repeatableRead(@PathVariable Long id) {
		accountservice.repeatableReadDemo(id);
		return "Check console output";
	}

	@GetMapping("/serializable/{id}")
	public String serializable(@PathVariable Long id) {
		accountservice.serializableRead(id);
		return "Serializable read completed";
	}

}
