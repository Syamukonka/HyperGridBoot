package com.major.hypergridboot.service;

import com.major.hypergridboot.entity.Transaction;

import java.util.List;

public interface TransactionService {
    Transaction savePayment(Transaction transaction);

    List<Transaction> fetchAllTransactions();

    List<Transaction> fetchAllTransactionsById(Long id);



}
