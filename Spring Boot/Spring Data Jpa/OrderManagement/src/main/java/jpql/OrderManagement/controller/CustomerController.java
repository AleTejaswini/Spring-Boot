package jpql.OrderManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jpql.OrderManagement.model.Customer;
import jpql.OrderManagement.model.Orders;
import jpql.OrderManagement.model.repository.CustomerRepository;
import jpql.OrderManagement.service.CustomerService;
@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerservice;
	@PostMapping("/addcustomer")
	public Customer addcustomer(@RequestBody Customer customer) {
		  return customerservice.addcustomer(customer);
	  }
	@GetMapping("/getCustomersByOrderStatus")
	public List<Customer> getCustomersByOrderStatus(@RequestParam String status){
		  return customerservice.getCustomersByOrderStatus(status);
	  }
	
	@GetMapping("/getCustomersByHighSpending")
	public List<Object[]> getCustomersByHighSpending(){
		  return customerservice.getCustomersByHighSpending();
	  }
	@GetMapping("/getLatestOrderByCustomer")
	public List<Orders> getLatestOrderByCustomer(){
		  return customerservice.getLatestOrderByCustomer();
	  }
	
	@GetMapping("/getOrdersSortedByCustomerName")
	 public List<Orders> getOrdersSortedByCustomerName(){
		  return customerservice.getOrdersSortedByCustomerName();
	  }
	@GetMapping("/getTop3CustomersByOrderCount")
	 public List<Object[]> getTop3CustomersByOrderCount(){
		  return customerservice.getTop3CustomersByOrderCount();
	  }
	 
	 //native sql query
	 @GetMapping("/getallcustomer")
		public List<Customer> getallcustomer(){
			return customerservice.getallcustomer();
		}
	 @GetMapping("/findbyname")
	 public List<Object[]> findbyname( @RequestParam String name){
		 return customerservice.findbyname(name);
	 }
}
