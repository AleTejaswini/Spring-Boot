package jpql.OrderManagement.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jpql.OrderManagement.model.Orders;
import jpql.OrderManagement.model.repository.OrderRepository;
import jpql.OrderManagement.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {
	@Autowired
	private OrderService orderservice;
	
	@PostMapping("/addorder")
	public Orders addorder(@RequestBody Orders order) {
		return orderservice.addorder(order);
	}
	
	
	
	@GetMapping("/getallordersbytotalamount")
	public List<Orders> getallordersbytotalamount() {
		return orderservice.getallordersbytotalamount();
	}
	@GetMapping("/getIDandTotalamount")
	public List<Object[]> getIDandTotalamount(){
		return orderservice.getIDandTotalamount();
	}
	
	@GetMapping("/getallordersbyorderdate")
	public List<Orders> getallordersbyorderdate(@RequestParam LocalDate date) {
		return orderservice.getallordersbyorderdate(date);
	}
	
	@GetMapping("/getallordersByorderdateAsc")
	public List<Orders> getallordersByorderdateAsc(){
		return orderservice.getallordersByorderdateAsc();
	}
	
	@GetMapping("/getorderslike")
	public List<Orders> getorderslike(){
		return orderservice.getorderslike();
	}
	
	@PutMapping("/updateorderstatus")
	public int updateorderstatus(@RequestParam String updatedstatus, @RequestParam int Id) {
		return orderservice.updateorderstatus(updatedstatus, Id);
	}
	
	@DeleteMapping("/deleteorders")
	public int deleteorders(@RequestParam int id) {
		return orderservice.deleteorders(id);
	}
	
	@GetMapping("/countorders")
	public int countorder() {
		return orderservice.countorder();
	}
	
	@GetMapping("/maxtotalamount")
	public int maxtotalamount() {
		return orderservice.maxtotalamount();
	}
	
	@GetMapping("/getordersingroup")
	public List<Object[]> getordersingroup(){
		return orderservice.getordersingroup();
	}
	
}
