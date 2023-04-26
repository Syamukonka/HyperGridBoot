package com.major.hypergridboot.controller;

import com.major.hypergridboot.entity.Customer;
import com.major.hypergridboot.exception.CustomerNotFoundException;
import com.major.hypergridboot.exception.InvalidCustomerDetailsException;
import com.major.hypergridboot.repository.CustomerRepository;
import com.major.hypergridboot.service.CustomerService;
import com.major.hypergridboot.service.CustomerServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:3000/"})
public class CustomerController {

    static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    CustomerService service;

    @GetMapping("/customers")
    public List<Customer> fetchCustomers (){
        LOGGER.info("Fetching customers");
        return service.fetchCustomers();
    }

    @GetMapping("/customers/{id}")
    public Customer fetchCustomerById(@PathVariable("id") Long id) throws CustomerNotFoundException {
        LOGGER.info("Fetching customer with id "+id);
        return service.fetchCustomerById(id);
    }

    @PostMapping("/customers")
    public Customer newCustomer(@RequestBody Customer customer) throws InvalidCustomerDetailsException {
        return service.saveCustomer(customer);
    }

    @PutMapping("/customers/{id}")
    public Customer updateCustomer(@RequestBody Customer customer){
        return service.updateCustomer(customer);
    }

    @DeleteMapping("customers/{id}")
    public String deleteCustomer(@PathVariable Long id){
        service.deleteCustomer(id);
        return "Deleted successfully";
    }

}
