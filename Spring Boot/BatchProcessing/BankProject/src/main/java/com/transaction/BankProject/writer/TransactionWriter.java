package com.transaction.BankProject.writer;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.transaction.BankProject.entity.Account;
import com.transaction.BankProject.entity.Transactions;
import com.transaction.BankProject.repository.AccountRepository;
import com.transaction.BankProject.repository.TransactionRepository;
@Component
public class TransactionWriter implements ItemWriter<Transactions> {
	@Autowired
	private AccountRepository accountrepository;
	@Autowired
	private TransactionRepository transactionrepository;
	
	@Override
	public void write(List<? extends Transactions> transactions) throws Exception {
		for(Transactions transaction : transactions) {
			transactionrepository.save(transaction);
//			Account account =  accountrepository.findById(transaction.getAccountNo())
//					.orElseThrow(()->new RuntimeException("Account not found"));
//			
			 Account account = accountrepository
	                    .findById(transaction.getAccountNo())
	                    .orElseGet(() -> {
	                        Account acc = new Account();
	                        acc.setAccountNo(transaction.getAccountNo());
	                        acc.setBalance(0);
	                        acc.setTotalcredits(0);
	                        acc.setTotaldebits(0);
	                        return acc;
	                    });
			if("CREDIT".equalsIgnoreCase(transaction.getType())) {
				account.setBalance(account.getBalance()+transaction.getAmount());
				account.setTotalcredits(account.getTotalcredits()+1);
			}
			else {
				account.setBalance(account.getBalance()-transaction.getAmount());
				account.setTotaldebits(account.getTotaldebits()+1);
			}
			accountrepository.save(account);
		}
	}

}
