package jpql.OrderManagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import jpql.OrderManagement.model.Customer;
import jpql.OrderManagement.model.Orders;
import jpql.OrderManagement.model.repository.CustomerRepository;

@Service
public class CustomerService {
  @Autowired
	private CustomerRepository customerrepository;
  
  public Customer addcustomer(Customer customer) {
	  return customerrepository.save(customer);
  }
  
  public List<Customer> getCustomersByOrderStatus(String status){
	  return customerrepository.getCustomersByOrderStatus(status);
  }
  
  public List<Object[]> getCustomersByHighSpending(){
	  return customerrepository.getCustomersByHighSpending();
  }
  
  public List<Orders> getLatestOrderByCustomer(){
	  return customerrepository.getLatestOrderByCustomer();
  }
  
  public List<Orders> getOrdersSortedByCustomerName(){
	  return customerrepository.getOrdersSortedByCustomerName();
  }
 
  public List<Object[]> getTop3CustomersByOrderCount(){
	  return customerrepository.getTop3CustomersByOrderCount();
  }
  
  //native sql query
	public List<Customer> getallcustomer(){
		return customerrepository.getallcustomer();
	}
	
	 public List<Object[]> findbyname( String name){
		 return customerrepository.findbyname(name);
	 }
 
}
