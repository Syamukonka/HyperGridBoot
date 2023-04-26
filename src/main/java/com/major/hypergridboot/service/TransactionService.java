package com.major.hypergridboot.service;

import com.major.hypergridboot.entity.Stats;
import com.major.hypergridboot.entity.Transaction;
import com.major.hypergridboot.exception.CustomerNotFoundException;

import java.util.List;

public interface TransactionService {
    Transaction savePayment(Transaction transaction) throws CustomerNotFoundException;

    List<Transaction> fetchAllTransactions();

    List<Transaction> fetchAllTransactionsById(Long id);


    List<Stats> getStats();
}
