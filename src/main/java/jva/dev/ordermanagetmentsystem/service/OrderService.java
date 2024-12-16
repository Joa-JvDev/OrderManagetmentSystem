package jva.dev.ordermanagetmentsystem.service;

import jva.dev.ordermanagetmentsystem.dto.CustomerDTO;
import jva.dev.ordermanagetmentsystem.dto.DishDTO;
import jva.dev.ordermanagetmentsystem.dto.OrderDTO;
import jva.dev.ordermanagetmentsystem.model.Customer;
import jva.dev.ordermanagetmentsystem.model.Dish;
import jva.dev.ordermanagetmentsystem.model.Order;
import jva.dev.ordermanagetmentsystem.repository.CustomerRepository;
import jva.dev.ordermanagetmentsystem.repository.DishRepository;
import jva.dev.ordermanagetmentsystem.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final ConversionService conversionService;

    @Autowired
    public OrderService(OrderRepository orderRepository, ConversionService conversionService) {
        this.orderRepository = orderRepository;
        this.conversionService = conversionService;
    }

    public OrderDTO createOrder(OrderDTO orderDTO){
        Order order = conversionService.convert(orderDTO, Order.class);
        Order savedOrder = orderRepository.save(order);

        return conversionService.convert(savedOrder, OrderDTO.class);
    }

    public OrderDTO updateOrder(Long id,OrderDTO order){
        Order orderUpdate = orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
        orderUpdate.setDishes(order.getDishes());
        orderUpdate.setTotal(order.getTotal());
        Order savedOrder = orderRepository.save(orderUpdate);
        return conversionService.convert(savedOrder, OrderDTO.class);
    }

    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }

    public void deleteOrder(Long id){orderRepository.deleteById(id);}
}
