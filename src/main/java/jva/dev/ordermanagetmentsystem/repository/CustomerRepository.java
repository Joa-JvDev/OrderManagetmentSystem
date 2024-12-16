package jva.dev.ordermanagetmentsystem.repository;

import jva.dev.ordermanagetmentsystem.model.Customer;
import jva.dev.ordermanagetmentsystem.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query("SELECT o FROM Order o WHERE o.customer.id = :customerId")
    List<Order> findOrdersByCustomerId(@Param("customerId") Long customerId);
}
