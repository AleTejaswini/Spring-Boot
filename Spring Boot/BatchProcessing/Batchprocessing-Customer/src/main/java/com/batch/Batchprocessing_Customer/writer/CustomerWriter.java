package com.batch.Batchprocessing_Customer.writer;

import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import com.batch.Batchprocessing_Customer.entity.Customer;
import com.batch.Batchprocessing_Customer.repository.CustomerRepository;

public class CustomerWriter implements ItemWriter<Customer> {
	@Autowired
	private CustomerRepository customerrepo;
	@Override
	public void write(Chunk<? extends Customer> chunk) throws Exception {
		System.out.println("ThreadName: "+Thread.currentThread().getName());
		customerrepo.saveAll(chunk);
		
	}

}
