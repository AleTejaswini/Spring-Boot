package com.transaction.BankProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.transaction.BankProject.entity.Account;

public interface AccountRepository extends JpaRepository<Account,String>{

}
