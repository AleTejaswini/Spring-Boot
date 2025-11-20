package jpql.OrderManagement.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jpql.OrderManagement.model.Orders;

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
	public List<Object[]> getIDandTotalamount() {
		return orderservice.getIDandTotalamount();
	}

	@GetMapping("/getallordersbyorderdate")
	public List<Orders> getallordersbyorderdate(@RequestParam LocalDate date) {
		return orderservice.getallordersbyorderdate(date);
	}

	@GetMapping("/getallordersByorderdateAsc")
	public List<Orders> getallordersByorderdateAsc() {
		return orderservice.getallordersByorderdateAsc();
	}

	@GetMapping("/getorderslike")
	public List<Orders> getorderslike() {
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
	public List<Object[]> getordersingroup() {
		return orderservice.getordersingroup();
	}

	@GetMapping("/getordershavingtotalamount")
	public List<Object[]> getordershavingtotalamount() {
		return orderservice.getordershavingtotalamount();
	}

	@GetMapping("/findProcessingOrders")
	public List<Orders> findProcessingOrders() {
		return orderservice.findProcessingOrders();
	}

	@GetMapping("/findOrdersWithAmountGreaterThan5000")
	public List<Orders> findOrdersWithAmountGreaterThan5000() {
		return orderservice.findOrdersWithAmountGreaterThan5000();
	}

	@GetMapping("/countOrdersByStatus")
	public List<Object[]> countOrdersByStatus() {
		return orderservice.countOrdersByStatus();
	}

	@GetMapping("/getMaxOrderAmount")
	public Double getMaxOrderAmount() {
		return orderservice.getMaxOrderAmount();
	}

	@GetMapping("/sortByStatusAndAmount")
	public List<Orders> sortByStatusAndAmount() {
		return orderservice.sortByStatusAndAmount();
	}

	@GetMapping("/sumPendingOrders")
	public Double sumPendingOrders() {
		return orderservice.sumPendingOrders();
	}

	@GetMapping("/findDeliveredOrShippedOrders")
	public List<Orders> findDeliveredOrShippedOrders() {
		return orderservice.findDeliveredOrShippedOrders();
	}

	@GetMapping("/findOldestOrder")
	public Orders findOldestOrder() {
		return orderservice.findOldestOrder();
	}

	@GetMapping("/findOrdersBeforeDate")
	public List<Orders> findOrdersBeforeDate(@RequestParam LocalDate orderDate) {
		return orderservice.findOrdersBeforeDate(orderDate);
	}

	@GetMapping("/findOrdersEndingWith75")
	public List<Orders> findOrdersEndingWith75() {
		return orderservice.findOrdersEndingWith75();
	}

	@GetMapping("/getMinAmountByStatus")
	public List<Object[]> getMinAmountByStatus() {
		return orderservice.getMinAmountByStatus();
	}

	@GetMapping("/countOrdersByDate")
	public List<Object[]> countOrdersByDate() {
		return orderservice.countOrdersByDate();
	}

	@GetMapping("/getStatusesHavingMoreThanTwoOrders")
	public List<Object[]> getStatusesHavingMoreThanTwoOrders() {
		return orderservice.getStatusesHavingMoreThanTwoOrders();
	}

	@GetMapping("/getStatusWithAvgAmountGreaterThan5000")
	public List<Object[]> getStatusWithAvgAmountGreaterThan5000() {
		return orderservice.getStatusWithAvgAmountGreaterThan5000();
	}

	@GetMapping("/findTopThreeExpensiveOrders")
	public List<Orders> findTopThreeExpensiveOrders(Pageable p) {
		return orderservice.findTopThreeExpensiveOrders(p);
	}

	@GetMapping("/findSecondHighestAmountOrder")
	public Orders findSecondHighestAmountOrder() {
		return orderservice.findSecondHighestAmountOrder();
	}

	@GetMapping("/findOrdersByStatusLengthGreaterThan8")
	public List<Orders> findOrdersByStatusLengthGreaterThan8() {
		return orderservice.findOrdersByStatusLengthGreaterThan8();
	}

	@GetMapping("/findOrdersByStatus")
	public List<Orders> findOrdersByStatus(@RequestParam String status) {
		return orderservice.findOrdersByStatus(status);
	}

	@GetMapping("/findOrdersBetweenDates")
	public List<Orders> findOrdersBetweenDates(@RequestParam LocalDate start, @RequestParam LocalDate end) {
		return orderservice.findOrdersBetweenDates(start, end);
	}

	@GetMapping("/findTopOrders")
	public List<Orders> findTopOrders(@RequestParam int pagenum, @RequestParam int size) {
		Pageable pagerequest = PageRequest.of(pagenum, size);
		return orderservice.findTopOrders(pagerequest);
	}

	@GetMapping("/findOrdersByStatusPaged")
	public Page<Orders> findOrdersByStatusPaged(@RequestParam String status, @RequestParam int pagenum,
			@RequestParam int size) {
		PageRequest pageable = PageRequest.of(pagenum, size);
		return orderservice.findOrdersByStatusPaged(status, pageable);
	}

	@GetMapping("/findOrdersSorted")
	public Page<Orders> findOrdersSorted(@RequestParam int pagenum, @RequestParam int size,
			@RequestParam String sortby) {
		Pageable pageable = PageRequest.of(pagenum, size, Sort.by(sortby).ascending());
		return orderservice.findOrdersSorted(pageable);
	}
}
