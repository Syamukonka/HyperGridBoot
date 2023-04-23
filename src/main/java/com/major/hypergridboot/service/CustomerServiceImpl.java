package com.major.hypergridboot.service;

import com.major.hypergridboot.entity.Customer;
import com.major.hypergridboot.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    CustomerRepository repository;

    @Override
    public List<Customer> fetchCustomers() {
        List<Customer> customers = repository.findAll();
        Collections.reverse(customers);
        return customers;
    }

    @Override
    public Customer fetchCustomerById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        customer.setUnits(0.0);
        return repository.save(customer);
    }

    @Override
    public void deleteCustomer(Long id){
        repository.deleteById(id);
    }
}
