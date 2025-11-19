package jpql.OrderManagement.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import jpql.OrderManagement.model.Orders;
import jpql.OrderManagement.model.repository.OrderRepository;


@Service
public class OrderService {
	@Autowired
	private OrderRepository orderrepository;
	
	public Orders addorder(Orders order) {
		return orderrepository.save(order);
	}
	
	public List<Orders> getallordersbytotalamount(){
		return orderrepository.getallordersbytotalamount();
	}
	
	public List<Object[]> getIDandTotalamount(){
		return orderrepository.getIDandTotalamount();
	}
	
	public List<Orders> getallordersbyorderdate(LocalDate date){
		return orderrepository.getallordersbyorderdate(date);
	}
	
	
	public List<Orders> getallordersByorderdateAsc(){
		return orderrepository.getallordersByorderdateAsc();
	}
	
	
	public List<Orders> getorderslike(){
		return orderrepository.getorderslike();
	}
	
	
	public int updateorderstatus( String updatedstatus, int Id) {
		return orderrepository.updateorderstatus(updatedstatus, Id);
	}
	
	
	public int deleteorders(int id) {
		return orderrepository.deleteorders(id);
	}
	
	
	public int countorder() {
		return orderrepository.countorder();
	}
	
	
	public int maxtotalamount() {
		return orderrepository.maxtotalamount();
	}
	
	public List<Object[]> getordersingroup(){
		return orderrepository.getordersingroup();
	}
}
