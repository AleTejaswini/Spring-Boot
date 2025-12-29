package com.batch.Batchprocessing_Customer.processor;

import org.springframework.batch.item.ItemProcessor;

import com.batch.Batchprocessing_Customer.entity.Customer;

public class CustomerProcessor implements ItemProcessor<Customer,Customer>{

	@Override
	public Customer process(Customer customer) throws Exception {
		// TODO Auto-generated method stub
		return customer;
	}
	

}
