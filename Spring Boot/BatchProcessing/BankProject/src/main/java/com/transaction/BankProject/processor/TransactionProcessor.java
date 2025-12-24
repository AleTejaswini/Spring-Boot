package com.transaction.BankProject.processor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;

import com.transaction.BankProject.entity.Account;
import com.transaction.BankProject.entity.Transactions;
import com.transaction.BankProject.repository.TransactionRepository;

public class TransactionProcessor  implements ItemProcessor<Transactions,Transactions>{
	
	 private static final DateTimeFormatter FORMATTER =
	            DateTimeFormatter.ofPattern("yyyy-MM-dd");

	@Override
	public Transactions process(Transactions transactions) throws Exception {


		
        LocalDate transactiondate = LocalDate.parse(transactions.getDate(), FORMATTER);

       
        if (!transactiondate.equals(LocalDate.now().minusDays(1))) {
            return null;
        }

		if (!"ACTIVE".equalsIgnoreCase(transactions.getStatus())) 
		{ 
			return null;
			} 
		return transactions;
	
	}
	
	
	
	}
