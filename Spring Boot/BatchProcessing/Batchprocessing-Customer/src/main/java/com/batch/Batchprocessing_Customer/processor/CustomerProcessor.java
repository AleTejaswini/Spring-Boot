package com.batch.Batchprocessing_Customer.processor;

import org.springframework.batch.item.ItemProcessor;

import com.batch.Batchprocessing_Customer.entity.Customer;

public class CustomerProcessor implements ItemProcessor<Customer, Customer> {

    @Override
    public Customer process(Customer customer) throws Exception {

        // Example validation
        if (customer.getEmail() == null || customer.getEmail().isEmpty()) {
            throw new IllegalArgumentException("Email is mandatory");
        }

        return customer;
    }
}