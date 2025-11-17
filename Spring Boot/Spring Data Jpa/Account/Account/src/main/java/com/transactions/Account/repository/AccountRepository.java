package com.transactions.Account.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.transactions.Account.model.Account;

public interface AccountRepository extends JpaRepository<Account, Integer> { }
