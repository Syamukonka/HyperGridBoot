package com.major.hypergridboot.service;

import com.major.hypergridboot.entity.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> fetchCustomers();

    Customer fetchCustomerById(Long id);

    Customer saveCustomer(Customer customer);

    void deleteCustomer(Long id);
}
