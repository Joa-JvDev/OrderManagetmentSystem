package jva.dev.ordermanagetmentsystem.repository;

import jva.dev.ordermanagetmentsystem.dto.OrderDTO;
import jva.dev.ordermanagetmentsystem.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
