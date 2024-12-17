package jva.dev.ordermanagetmentsystem.service;

import jva.dev.ordermanagetmentsystem.dto.CustomerDTO;
import jva.dev.ordermanagetmentsystem.model.Customer;
import jva.dev.ordermanagetmentsystem.model.Order;
import jva.dev.ordermanagetmentsystem.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final ConversionService conversionService;

    @Autowired
    public CustomerService(CustomerRepository customerRepository, ConversionService conversionService) {
        this.customerRepository = customerRepository;
        this.conversionService = conversionService;
    }

    @Transactional(timeout = 1)
    public CustomerDTO createCustomer(CustomerDTO customer) {
        Customer newCustomer = conversionService.convert(customer, Customer.class);
        Customer savedCustomer = customerRepository.save(Objects.requireNonNull(newCustomer));
        return conversionService.convert(savedCustomer, CustomerDTO.class);
     }

    public CustomerDTO updateCustomer(Long id, Customer customer) {
        if (id == null) {
            throw new RuntimeException("Customer no exist");
        }

        Customer findCustomer = customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Customer not found"));
        findCustomer.setFirstName(customer.getFirstName());
        findCustomer.setEmail(customer.getEmail());
        findCustomer.setPhone(customer.getPhone());

        Customer updatedCustomer = conversionService.convert(findCustomer, Customer.class);
        return conversionService.convert(customerRepository.save(Objects.requireNonNull(updatedCustomer)), CustomerDTO.class);
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public List<Order> getAllOrders(Long id) {
        return customerRepository.findOrdersByCustomerId(id);
    }
}
