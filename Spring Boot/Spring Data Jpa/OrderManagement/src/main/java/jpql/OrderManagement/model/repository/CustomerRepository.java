package jpql.OrderManagement.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jpql.OrderManagement.model.Customer;
@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer>{

}
