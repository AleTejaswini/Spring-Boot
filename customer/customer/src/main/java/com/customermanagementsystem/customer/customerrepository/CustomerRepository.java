package com.customermanagementsystem.customer.customerrepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.customermanagementsystem.customer.customerentity.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Integer>{

}
