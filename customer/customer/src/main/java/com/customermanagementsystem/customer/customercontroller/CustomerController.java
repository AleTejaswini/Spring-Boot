package com.customermanagementsystem.customer.customercontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customermanagementsystem.customer.customerentity.Customer;
import com.customermanagementsystem.customer.customerservice.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerservice;

	@GetMapping("/getall")
	public List<Customer> getall() {
		return customerservice.getallcustomers();
	}

	@GetMapping("/getbyid/{id}")
	public Customer getbyid(@PathVariable int id) {
		return customerservice.getbyid(id);
	}

	@PostMapping("/addnewcustomer")
	public Customer addnewcustomer(@RequestBody Customer c) {
		 return customerservice.addcustomer(c);
		
	}

	@PutMapping("/updatecust/{id}")
	public Customer updatecust(@PathVariable int id, @RequestBody Customer c) {
		return customerservice.updatecustomer(id, c);
	}

	@DeleteMapping("/deleteall")
	public void deleteall() {
		customerservice.deleteallcustomer();
	}

	@DeleteMapping("/deletebyid/{id}")
	public void deletebyid(@PathVariable int id) {
		customerservice.deletebyid(id);
	}
}
