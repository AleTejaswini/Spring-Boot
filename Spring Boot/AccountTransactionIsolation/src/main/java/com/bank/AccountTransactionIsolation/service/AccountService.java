package com.bank.AccountTransactionIsolation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.bank.AccountTransactionIsolation.entity.Account;
import com.bank.AccountTransactionIsolation.repository.AccountRepository;

@Service
public class AccountService {
	@Autowired
	private AccountRepository accountrepository;

	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public void debitwithdelay(Long id, int amount) {

		Account account = accountrepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Account with " + id + " not found"));
		account.setBalance(account.getBalance() - amount);
		accountrepository.save(account);
		System.out.println("Account debited but not yet committed");

		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			e.getMessage();
		}

		System.out.println("Transaction completed will commit now");

	}

	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public Account getaccount(Long id) {
		return accountrepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Account with " + id + " not found"));

	}

//	@Transactional(isolation = Isolation.READ_COMMITTED)
//	public Account getaccount(Long id) {
//		return accountrepository.findById(id)
//				.orElseThrow(() -> new RuntimeException("Account with " + id + " not found"));
//		
//	}

	@Transactional(isolation = Isolation.REPEATABLE_READ)
	public void repeatableReadDemo(Long id) {
		System.out.println("First Read:");
		System.out.println(accountrepository.findById(id).get().getBalance());

		try {
			Thread.sleep(15000); // wait 15 seconds
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Second Read:");
		System.out.println(accountrepository.findById(id).get().getBalance());
	}

	@Transactional(isolation = Isolation.SERIALIZABLE)
	public void serializableRead(Long id) {
		Account account = accountrepository.findById(id).get();
		System.out.println("First Read: " + account.getBalance());

		try {
			Thread.sleep(15000); // wait 15 seconds
		} catch (InterruptedException e) {
		}

		Account accountAgain = accountrepository.findById(id).get();
		System.out.println("Second Read: " + accountAgain.getBalance());
	}

}
