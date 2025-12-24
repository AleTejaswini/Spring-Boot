package com.transaction.BankProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.transaction.BankProject.entity.Transactions;

public interface TransactionRepository extends JpaRepository<Transactions,Integer>{

	
}
