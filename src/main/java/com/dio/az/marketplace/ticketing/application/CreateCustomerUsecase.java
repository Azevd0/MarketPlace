package com.dio.az.marketplace.ticketing.application;

import com.dio.az.marketplace.commom.infrastructure.event.dto.CustomerCreated;
import com.dio.az.marketplace.ticketing.domain.customer.Customer;
import com.dio.az.marketplace.ticketing.domain.customer.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateCustomerUsecase {
    private final CustomerRepository customerRepository;

    public CreateCustomerUsecase(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    public void execute(CustomerCreated event){
        var customer = new Customer(event.id(), event.name());
        customerRepository.save(customer);
    }
}
