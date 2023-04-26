package com.major.hypergridboot.service;

import com.major.hypergridboot.entity.Customer;
import com.major.hypergridboot.exception.CustomerNotFoundException;
import com.major.hypergridboot.exception.InvalidCustomerDetailsException;
import com.major.hypergridboot.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static com.major.hypergridboot.service.Tools.isWhole;

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
    public Customer fetchCustomerById(Long id) throws CustomerNotFoundException {

        Optional<Customer> optCustomer = repository.findById(id);

        if(optCustomer.isEmpty())
            throw new CustomerNotFoundException("No customer found with id "+id);
        return optCustomer.get();

    }

    @Override
    public Customer saveCustomer(Customer customer) throws InvalidCustomerDetailsException {
        if(isWhole(customer.getName()) && isWhole(customer.getType())) {
            customer.setUnits(0.0);
            return repository.save(customer);
        }
        else
            throw new InvalidCustomerDetailsException("Could not create a new customer. Make sure you include the name and type details");
    }

    @Override
    public void deleteCustomer(Long id){
        repository.deleteById(id);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        return repository.save(customer);
    }
}
