package com.major.hypergridboot.controller;

import com.major.hypergridboot.entity.Stats;
import com.major.hypergridboot.entity.Transaction;
import com.major.hypergridboot.exception.CustomerNotFoundException;
import com.major.hypergridboot.service.TransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:3000"})
public class TransactionController {

    @Autowired
    TransactionService service;

    private final Logger LOGGER = LoggerFactory.getLogger(TransactionController.class);
    @PostMapping("/transactions/pay")
    public Transaction payForId(@RequestBody Transaction transaction) throws CustomerNotFoundException {
        LOGGER.info("Processing Payment for "+transaction.getCustomerId());
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

    @GetMapping("transactions/stats")
    public List<Stats> getStats(){

        return service.getStats();
    }

}
