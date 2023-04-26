package com.major.hypergridboot.repository;

import com.major.hypergridboot.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    public List<Transaction> findTransactionByCustomerId(Long customerId);

}
