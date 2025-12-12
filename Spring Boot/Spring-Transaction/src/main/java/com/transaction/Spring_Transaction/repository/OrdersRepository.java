package com.transaction.Spring_Transaction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.transaction.Spring_Transaction.entity.Orders;
@Repository
public interface OrdersRepository extends JpaRepository<Orders,Integer>{

}
