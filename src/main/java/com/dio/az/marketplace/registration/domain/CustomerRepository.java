package com.dio.az.marketplace.registration.domain;

import java.util.List;

public interface CustomerRepository {
    Customer save(Customer customer);
    public List<Customer> findAll();

}
