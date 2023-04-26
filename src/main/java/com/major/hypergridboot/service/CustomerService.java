package com.major.hypergridboot.service;

import com.major.hypergridboot.entity.Customer;
import com.major.hypergridboot.exception.CustomerNotFoundException;
import com.major.hypergridboot.exception.InvalidCustomerDetailsException;

import java.util.List;

public interface CustomerService {
    List<Customer> fetchCustomers();

    Customer fetchCustomerById(Long id) throws CustomerNotFoundException;

    Customer saveCustomer(Customer customer) throws InvalidCustomerDetailsException;

    void deleteCustomer(Long id);

    Customer updateCustomer(Customer customer);


}
