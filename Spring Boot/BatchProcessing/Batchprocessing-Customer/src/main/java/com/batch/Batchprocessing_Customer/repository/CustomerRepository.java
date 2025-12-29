package com.batch.Batchprocessing_Customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.batch.Batchprocessing_Customer.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
