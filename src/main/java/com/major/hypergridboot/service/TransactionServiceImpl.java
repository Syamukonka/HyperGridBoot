package com.major.hypergridboot.service;

import com.major.hypergridboot.entity.Customer;
import com.major.hypergridboot.entity.Stats;
import com.major.hypergridboot.entity.Transaction;
import com.major.hypergridboot.exception.CustomerNotFoundException;
import com.major.hypergridboot.repository.CustomerRepository;
import com.major.hypergridboot.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService{

    @Autowired
    TransactionRepository repository;

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Transaction savePayment(Transaction transaction) throws CustomerNotFoundException {

        Customer customer = customerRepository.findById(transaction.getCustomerId()).orElse(null);
        if(customer==null)
            throw new CustomerNotFoundException("No customer found with id "+transaction.getCustomerId());

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
        List<Transaction> transactions = repository.findAll();
        Collections.reverse(transactions);
        return transactions;
    }

    @Override
    public List<Transaction> fetchAllTransactionsById(Long id) {
        List<Transaction> transactions = repository.findTransactionByCustomerId(id);
        Collections.reverse(transactions);
        return transactions;
    }

    @Override
    public List<Stats> getStats() {

        List<Transaction> transactions = repository.findAll();
        //Using Stream Reducer to calculate the total revenue from all transactions
        Double revenue = transactions.stream()
                .map(Transaction::getAmount)
                .reduce(0.0, Double::sum);

        //Using Stream Reducer to calculate the total power supplied from all transactions
        Double supplied = transactions.stream()
                .map(Transaction::getUnits)
                .reduce(0.0, Double::sum);

        List<Stats> stats = new ArrayList<>();

        //Creating stats for Revenue and power supplied
        stats.add(Stats.builder().value(revenue).caption("REVENUE").info("Last 30 days").prefix("Rs.").build());
        stats.add(Stats.builder().value(supplied).caption("POWER SUPPLIED").info("Last 30 days").suffix("KWH").build());

        return stats;
    }
}
