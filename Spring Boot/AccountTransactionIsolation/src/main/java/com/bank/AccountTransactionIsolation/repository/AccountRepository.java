package com.bank.AccountTransactionIsolation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.AccountTransactionIsolation.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

}
