package com.major.hypergridboot.service;

import com.major.hypergridboot.entity.Customer;
import com.major.hypergridboot.entity.Transaction;
import com.major.hypergridboot.repository.CustomerRepository;
import com.major.hypergridboot.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService{

    @Autowired
    TransactionRepository repository;

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Transaction savePayment(Transaction transaction) {

        Customer customer = customerRepository.findById(transaction.getCustomerId()).orElse(null);
        if(customer==null)
            return null;

        System.out.println("\nTRANSACTION"+transaction+"\n");
        customer.updateUnits(transaction.getUnits());
        customerRepository.save(customer);

        transaction.setCustomerName(customer.getName());
        transaction.setDate(new Date(System.currentTimeMillis()));
        transaction.setTime(new Time(System.currentTimeMillis()));
        return repository.save(transaction);
    }

    @Override
    public List<Transaction> fetchAllTransactions() {
        return repository.findAll();
    }

    @Override
    public List<Transaction> fetchAllTransactionsById(Long id) {
        return repository.findTransactionByCustomerId(id);
    }
}
