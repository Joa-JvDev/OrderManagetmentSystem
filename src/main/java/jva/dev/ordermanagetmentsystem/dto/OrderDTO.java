package jva.dev.ordermanagetmentsystem.dto;

import jva.dev.ordermanagetmentsystem.enums.OrderStatus;
import jva.dev.ordermanagetmentsystem.model.Customer;
import jva.dev.ordermanagetmentsystem.model.Dish;

import java.time.LocalDateTime;
import java.util.List;

public class OrderDTO {

    private Long id;
    private Customer customer;
    private List<Dish> dishes;
    private LocalDateTime orderDate;
    private OrderStatus status;
    private Double total;

    public OrderDTO(Long id, Customer customer, List<Dish> dishes, LocalDateTime orderDate, OrderStatus status, Double total) {
        this.id = id;
        this.customer = customer;
        this.dishes = dishes;
        this.orderDate = orderDate;
        this.status = status;
        this.total = total;
    }

    public OrderDTO() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
