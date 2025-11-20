package jpql.OrderManagement.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

	public List<Orders> getallordersbytotalamount() {
		return orderrepository.getallordersbytotalamount();
	}

	public List<Object[]> getIDandTotalamount() {
		return orderrepository.getIDandTotalamount();
	}

	public List<Orders> getallordersbyorderdate(LocalDate date) {
		return orderrepository.getallordersbyorderdate(date);
	}

	public List<Orders> getallordersByorderdateAsc() {
		return orderrepository.getallordersByorderdateAsc();
	}

	public List<Orders> getorderslike() {
		return orderrepository.getorderslike();
	}

	public int updateorderstatus(String updatedstatus, int Id) {
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

	public List<Object[]> getordersingroup() {
		return orderrepository.getordersingroup();
	}

	public List<Object[]> getordershavingtotalamount() {
		return orderrepository.getordershavingtotalamount();
	}

	public List<Orders> findProcessingOrders() {
		return orderrepository.findProcessingOrders();
	}

	public List<Orders> findOrdersWithAmountGreaterThan5000() {
		return orderrepository.findOrdersWithAmountGreaterThan5000();
	}

	public List<Object[]> countOrdersByStatus() {
		return orderrepository.countOrdersByStatus();
	}

	public Double getMaxOrderAmount() {
		return orderrepository.getMaxOrderAmount();
	}

	public List<Orders> sortByStatusAndAmount() {
		return orderrepository.sortByStatusAndAmount();
	}

	public Double sumPendingOrders() {
		return orderrepository.sumPendingOrders();
	}

	public List<Orders> findDeliveredOrShippedOrders() {
		return orderrepository.findDeliveredOrShippedOrders();
	}

	public Orders findOldestOrder() {
		return orderrepository.findOldestOrder();
	}

	public List<Orders> findOrdersBeforeDate(LocalDate orderDate) {
		return orderrepository.findOrdersBeforeDate(orderDate);
	}

	public List<Orders> findOrdersEndingWith75() {
		return orderrepository.findOrdersEndingWith75();
	}

	public List<Object[]> getMinAmountByStatus() {
		return orderrepository.getMinAmountByStatus();
	}

	public List<Object[]> countOrdersByDate() {
		return orderrepository.countOrdersByDate();
	}

	public List<Object[]> getStatusesHavingMoreThanTwoOrders() {
		return orderrepository.getStatusesHavingMoreThanTwoOrders();
	}

	public List<Object[]> getStatusWithAvgAmountGreaterThan5000() {
		return orderrepository.getStatusWithAvgAmountGreaterThan5000();
	}

	public List<Orders> findTopThreeExpensiveOrders(Pageable p) {
		Pageable pagerequest = PageRequest.of(0, 3);
		return orderrepository.findTopThreeExpensiveOrders(pagerequest);
	}

	public Orders findSecondHighestAmountOrder() {
		return orderrepository.findSecondHighestAmountOrder();
	}

	public List<Orders> findOrdersByStatusLengthGreaterThan8() {
		return orderrepository.findOrdersByStatusLengthGreaterThan8();
	}

	public List<Orders> findOrdersByStatus(String status) {
		return orderrepository.findOrdersByStatus(status);
	}

	public List<Orders> findOrdersBetweenDates(LocalDate start, LocalDate end) {
		return orderrepository.findOrdersBetweenDates(start, end);
	}

	public List<Orders> findTopOrders(Pageable pageable) {
		return orderrepository.findTopOrders(pageable);
	}

	public Page<Orders> findOrdersByStatusPaged(String status, Pageable pageable) {
		return orderrepository.findOrdersByStatusPaged(status, pageable);
	}

	public Page<Orders> findOrdersSorted(Pageable pageable) {
		return orderrepository.findOrdersSorted(pageable);
	}
}
