package com.major.hypergridboot.service;

import com.major.hypergridboot.entity.Customer;
import com.major.hypergridboot.exception.CustomerNotFoundException;
import com.major.hypergridboot.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.event.annotation.BeforeTestClass;
import org.springframework.test.context.event.annotation.BeforeTestMethod;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerServiceTest {

    private final Logger LOGGER = LoggerFactory.getLogger(CustomerServiceTest.class);


    @Autowired private CustomerService service;

    @MockBean
    private CustomerRepository repository;
    @BeforeEach
    public void setUp() {
        Customer customer = Customer.builder()
                .id(1)
                .name("Anita Joy")
                .address("Lusaka")
                .units(0.0)
                .type("Domestic")
                .build();

        Mockito.when(repository.findById(1L)).thenReturn(Optional.of(customer));
    }

    @Test
    @DisplayName("Find customer by ID")
    public void FindCustomerById() throws CustomerNotFoundException {
        Customer customer = service.fetchCustomerById(1L);
        assertNotNull(customer);
        assertEquals("Anita Joy",customer.getName());

        LOGGER.info("Fetch customer by ID passed");
    }


    @Test
    @DisplayName("Throw Exception for invalid customer ID")
    public void ThrowExceptionWhenForInvalidCustomerId() throws CustomerNotFoundException {

        var error = assertThrows(CustomerNotFoundException.class,
                () -> {
                    service.fetchCustomerById(333L);
                });

        assertEquals("No customer found with id 333",error.getMessage());

        LOGGER.info("Reject invalid customer-ID passed");
    }

}