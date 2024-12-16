package jva.dev.ordermanagetmentsystem.repository;

import jva.dev.ordermanagetmentsystem.model.Dish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DishRepository extends JpaRepository<Dish, Long> {
}
