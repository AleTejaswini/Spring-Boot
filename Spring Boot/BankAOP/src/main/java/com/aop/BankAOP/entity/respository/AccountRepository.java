package com.aop.BankAOP.entity.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aop.BankAOP.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Integer> {

}
