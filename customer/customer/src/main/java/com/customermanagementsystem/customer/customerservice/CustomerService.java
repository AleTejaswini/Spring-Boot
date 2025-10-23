package com.customermanagementsystem.customer.customerservice;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customermanagementsystem.customer.customerentity.Customer;
import com.customermanagementsystem.customer.customerrepository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerrepository;

	public Customer addcustomer(Customer c) {
		return customerrepository.save(c);
		
	}

	public List<Customer> getallcustomers() {
		return customerrepository.findAll();
	}

	public Customer getbyid(int id) {
		return customerrepository.findById(id).orElse(null);
	}

	public Customer updatecustomer(int id, Customer updatedcust) {
		Customer existing = customerrepository.findById(id).orElse(null);
		if (existing == null) {
			return null;
		}
		existing.setName(updatedcust.getName());
		existing.setEmail(updatedcust.getEmail());
		existing.setAddress(updatedcust.getAddress());
		existing.setPhonenumber(updatedcust.getPhonenumber());
		return customerrepository.save(existing);
		  
	}

	public void deleteallcustomer() {
		customerrepository.deleteAll();
	}

	public void deletebyid(int id) {
		customerrepository.deleteById(id);
	}

}
