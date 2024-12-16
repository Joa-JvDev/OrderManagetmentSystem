package jva.dev.ordermanagetmentsystem.controller;

import jva.dev.ordermanagetmentsystem.dto.OrderDTO;
import jva.dev.ordermanagetmentsystem.model.Order;
import jva.dev.ordermanagetmentsystem.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("order")
public class OrderController{

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping(value = "/create")
    public ResponseEntity<OrderDTO> createOrder(@RequestBody OrderDTO orderDTO){
        OrderDTO createdOrder = orderService.createOrder(orderDTO);
        return new ResponseEntity<>(createdOrder, HttpStatus.CREATED);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<OrderDTO> updateOrder(@PathVariable Long id, @RequestBody OrderDTO order){

        OrderDTO updateOrder = orderService.updateOrder(id,order);
        return new ResponseEntity<>(updateOrder, HttpStatus.OK);
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<Order>> getAllOrders(){
        return new ResponseEntity<>(orderService.getAllOrders(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteOrder(@PathVariable Long id){
        orderService.deleteOrder(id);
    }


}
