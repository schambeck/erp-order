package com.schambeck.erp.order.repository;

import com.schambeck.erp.order.domain.Customer;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Repository
public class CustomerRepository {

    public List<Customer> findAll() {
        return CUSTOMERS;
    }

    private final static List<Customer> CUSTOMERS = Arrays.asList(
            Customer.builder().id(UUID.randomUUID()).name("Marcelo").build(),
            Customer.builder().id(UUID.randomUUID()).name("Barbara").build(),
            Customer.builder().id(UUID.randomUUID()).name("Francisco").build()
    );

    private static final Random RAND = new Random();

    public static Customer newRandomCustomer() {
        return CUSTOMERS.get(RAND.nextInt(CUSTOMERS.size()));
    }

}
