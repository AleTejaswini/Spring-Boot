package com.transactions.Account.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.transactions.Account.model.Account;
import com.transactions.Account.repository.AccountRepository;

@Service
public class AccountService {
	@Autowired
    private AccountRepository accountrepository;

    @Transactional
    public void transfer(int fromId, int toId, int amt) {

        Account from = accountrepository.findById(fromId).orElseThrow();
        Account to = accountrepository.findById(toId).orElseThrow();

        from.setBalance(from.getBalance() - amt);
        accountrepository.save(from);

        if (amt > 10000) {
            throw new RuntimeException("Amount too high");
        }

        to.setBalance(to.getBalance() + amt);
        accountrepository.save(to);
    }
}