package com.major.hypergridboot.repository;

import com.major.hypergridboot.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseStatus;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {

}
