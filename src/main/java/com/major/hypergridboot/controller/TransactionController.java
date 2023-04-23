package com.major.hypergridboot.controller;

import com.major.hypergridboot.entity.Transaction;
import com.major.hypergridboot.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:3000"})
public class TransactionController {

    @Autowired
    TransactionService service;

    @PostMapping("/transactions/pay")
    public Transaction payForId(@RequestBody Transaction transaction){
        return service.savePayment(transaction);
    }

    @GetMapping("/transactions")
    public List<Transaction> fetchTransactions(){
        return service.fetchAllTransactions();
    }
    @GetMapping("/transactions/{id}")
    public List<Transaction> fetchTransactionsForId(@PathVariable("id") Long id ){
        return service.fetchAllTransactionsById(id);
    }

}
