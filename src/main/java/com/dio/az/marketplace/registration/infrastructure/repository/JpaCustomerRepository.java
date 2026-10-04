package com.dio.az.marketplace.registration.infrastructure.repository;

import com.dio.az.marketplace.registration.domain.Customer;
import com.dio.az.marketplace.registration.domain.CustomerRepository;

import java.util.List;

public class JpaCustomerRepository implements CustomerRepository {
    @Override
    public Customer save(Customer customer) {
        return null;
    }

    @Override
    public List<Customer> findAll() {
        return List.of();
    }
}
