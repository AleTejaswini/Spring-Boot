package jpql.OrderManagement.model.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jpql.OrderManagement.model.Orders;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Integer> {

	@Query("select o from Orders o where o.totalAmount>10000")
	List<Orders> getallordersbytotalamount();

	@Query("select o.id , o.totalAmount from Orders o where o.totalAmount>10000")
	List<Object[]> getIDandTotalamount();

	@Query("select o from Orders o where o.orderDate >= :date")
	List<Orders> getallordersbyorderdate(@Param("date") LocalDate date);

	@Query("select o from Orders o order by orderDate asc")
	List<Orders> getallordersByorderdateAsc();

	@Query("select o from Orders o where status like 'P%'")
	List<Orders> getorderslike();

	@Modifying
	@Transactional
	@Query("update Orders o set o.status = :updatedstatus where o.id = :Id")
	int updateorderstatus(@Param("updatedstatus") String updatedstatus, @Param("Id") int Id);

	@Modifying
	@Transactional
	@Query("delete from Orders o where id = :ID")
	int deleteorders(@Param("ID") int id);

	@Query("select count(o.id) from Orders o")
	int countorder();

	@Query("select max(o.totalAmount) from Orders o")
	int maxtotalamount();

	@Query("select count(o) , o.status from Orders o group by status")
	List<Object[]> getordersingroup();

	@Query("select o.status, count(o) from Orders o  where o.totalAmount > 5000 group by o.status")
	List<Object[]> getordershavingtotalamount();

	@Query("select o from Orders o where o.status = 'PROCESSING' ")
	List<Orders> findProcessingOrders();

	@Query("select o from Orders o where o.totalAmount >5000 ")
	List<Orders> findOrdersWithAmountGreaterThan5000();

	@Query("select o.status ,count(o.id) from Orders o group by o.status")
	List<Object[]> countOrdersByStatus();

	@Query("select max(o.totalAmount) from Orders o")
	Double getMaxOrderAmount();

	@Query("select o from Orders o order by o.status asc, o.totalAmount asc")
	List<Orders> sortByStatusAndAmount();

	@Query("select sum(o.totalAmount) from Orders o where o.status = 'Pending'")
	Double sumPendingOrders();

	@Query("select o from Orders o where status in('delivered','shipped')")
	List<Orders> findDeliveredOrShippedOrders();

	@Query("select o from Orders o where str(o.totalAmount) like '%.75' ")
	List<Orders> findOrdersEndingWith75();

	@Query("select o from Orders o where o.orderDate <= :orderdate")
	List<Orders> findOrdersBeforeDate(@Param("orderdate") LocalDate orderDate);

	@Query("select o from Orders o where orderDate =(select min(o.orderDate) from Orders o)")
	Orders findOldestOrder();

	@Query("select o.status,min(o.totalAmount) from Orders o group by o.status")
	List<Object[]> getMinAmountByStatus();

	@Query("select o.orderDate ,count(o.id) from Orders o group by o.orderDate")
	List<Object[]> countOrdersByDate();

	@Query("select o.status from Orders o group by o.status having count(o.id) >2")
	List<Object[]> getStatusesHavingMoreThanTwoOrders();

	@Query("select o.status from Orders o group by o.status having avg(o.totalAmount)>5000")
	List<Object[]> getStatusWithAvgAmountGreaterThan5000();

	@Query("select o from Orders o order by o.totalAmount desc")
	List<Orders> findTopThreeExpensiveOrders(Pageable p);

	@Query("select o from Orders o order by o.totalAmount desc limit 1 offset 1")
	Orders findSecondHighestAmountOrder();

	@Query("select o from Orders o where length(o.status) >8")
	List<Orders> findOrdersByStatusLengthGreaterThan8();

	@Query("select o from Orders o where o.status = :status")
	List<Orders> findOrdersByStatus(@Param("status") String status);

	@Query("select o from Orders o where o.orderDate between :start and :end")
	List<Orders> findOrdersBetweenDates(@Param("start") LocalDate start, @Param("end") LocalDate end);

	@Query("select o from Orders o order by o.totalAmount desc")
	List<Orders> findTopOrders(Pageable pageable);

	@Query("select o from Orders o where o.status = :status  ")
	Page<Orders> findOrdersByStatusPaged(@Param("status") String status, Pageable pageable);

	@Query("select o from Orders o")
	Page<Orders> findOrdersSorted(Pageable pageable);

	
	// joins
	@Query("select  o, c.name FROM Orders o JOIN o.customer c")
	List<Object[]> getOrdersWithCustomerNames();

//	Get order ID and customer name
	@Query("select o.id , c.name from Orders o join o.customer c")
	List<Object[]> getOrderIdAndCustomerName();
	
//	Get customer names of people who placed at least one order
	@Query("select c.name from Orders o join o.customer c group by c.name having count(o)>1")
	List<String> getCustomersWhoOrdered();
	
//	Get total order amount and corresponding customer name
	@Query("select  c.name ,sum(o.totalAmount) from Orders o join o.customer c group by c.name")
	List<Object[]> getOrderAmountAndCustomer();
	
//	Get all customers even if they do not have any order
	@Query("select c from  Customer c left join c.orders o ")
	List<Object[]> getAllCustomersWithOrders();
	
	
//	Get number of orders placed by each customer
	@Query("select c.name ,count(o.id) from Orders o join o.customer c group by c.name")
	List<Object[]> countOrdersByCustomer();
	
//	Get only customers who placed more than 1 order
	@Query("select c.name from Orders o join o.customer c group by c.name having count(o.id)= :numoforders")
	List<String> getCustomersWithMultipleOrders(@Param("numoforders") int numoforders);
	
//	Get max order amount of each customer
	@Query("select c.name , max(o.totalAmount) from Orders o join o.customer c group by c.name")
	List<Object[]> getMaxOrderAmountByCustomer();
	
	
	
	//named sql queries
	@Query(name = "findordersbyname")
	List<Orders> findordersbyname(@Param("name") String name);
	@Query(name = "findordersbystatus")
	List<Orders> findordersbystatus(@Param("status") String status);
}
