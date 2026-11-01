package com.dio.az.marketplace.ticketing.infrastructure.persistence.repository;

import com.dio.az.marketplace.ticketing.domain.customer.Customer;
import com.dio.az.marketplace.ticketing.domain.customer.CustomerRepository;

public class PGCustomerRepository implements CustomerRepository {
    private final CustomerCRUDRepository customerCRUDRepository;

    public PGCustomerRepository(CustomerCRUDRepository customerCRUDRepository) {
        this.customerCRUDRepository = customerCRUDRepository;
    }

    @Override
    public void save(Customer customer) {
        var entity = new com.dio.az.marketplace.ticketing.infrastructure.persistence.entity.Customer(
                customer.getId(),
                customer.getCorrelationId().id(),
                customer.getName()
        );
        customerCRUDRepository.save(entity);
    }
}
