package jpql.OrderManagement.model.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jpql.OrderManagement.model.Orders;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface OrderRepository extends JpaRepository<Orders,Integer>{
	
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
		
	
	
	
}
