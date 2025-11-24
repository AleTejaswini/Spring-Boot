package jpql.OrderManagement.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jpql.OrderManagement.model.Customer;
import jpql.OrderManagement.model.Orders;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {

//	Get customer details based on order status
	@Query("select c  from Customer c join c.orders o  where o.status =:status")
	List<Customer> getCustomersByOrderStatus(@Param("status")String status);

//	Get customers whose total spending exceeds 10,000
	@Query("select c.name , sum(o.totalAmount) from Customer c join c.orders o group by c.name having sum(o.totalAmount) >10000")
	List<Object[]> getCustomersByHighSpending();

	//	Get most recent order placed by every customer
	@Query("select o from Orders o where o.orderDate = (select max(o2.orderDate) from Orders o2 where o2.customer = o.customer)")
	List<Orders> getLatestOrderByCustomer();

//	Get orders sorted by customer name then by totalAmount
	@Query("select o from Orders o join o.customer c order by c.name asc ")
	List<Orders> getOrdersSortedByCustomerName();
	
	
//	Get top 3 customers based on order count
	@Query("select c.name , count(o.id) from Customer c join c.orders o group by c.name order by count(o.id) desc limit 6")
	List<Object[]> getTop3CustomersByOrderCount();
	
	
	//using native sql query
	@Query(value = "select * from customer " ,nativeQuery=true)
	List<Customer> getallcustomer();
	
	@Query(name = "findbyname")
	List<Object[]> findbyname(@Param("name") String name);
}
