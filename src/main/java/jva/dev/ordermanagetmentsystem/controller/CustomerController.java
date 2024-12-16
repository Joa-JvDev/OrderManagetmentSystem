package jva.dev.ordermanagetmentsystem.controller;

import jva.dev.ordermanagetmentsystem.dto.CustomerDTO;
import jva.dev.ordermanagetmentsystem.model.Customer;
import jva.dev.ordermanagetmentsystem.model.Order;
import jva.dev.ordermanagetmentsystem.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("customer")
public class CustomerController {

    CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping(value = "/create")
    public ResponseEntity<CustomerDTO> createCustomer(@RequestBody CustomerDTO customer) {
        CustomerDTO newCustomer = customerService.createCustomer(customer);
        return new ResponseEntity<>(newCustomer, HttpStatus.CREATED) ;
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<CustomerDTO> updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {
        CustomerDTO customerUpdate = customerService.updateCustomer(id,customer);
        return new ResponseEntity<>(customerUpdate, HttpStatus.OK);
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        return new ResponseEntity<>(customerService.getAllCustomers(),HttpStatus.OK);
    }

    @GetMapping(value = "/orders/{id}")
    public ResponseEntity<List<Order>> getAllOrders(@PathVariable Long id) {
        return new ResponseEntity<>(customerService.getAllOrders(id),HttpStatus.OK);
    }

}
