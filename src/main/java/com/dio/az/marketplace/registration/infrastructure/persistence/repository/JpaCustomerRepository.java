package com.dio.az.marketplace.registration.infrastructure.persistence.repository;

import com.dio.az.marketplace.commom.infrastructure.event.dto.CustomerCreated;
import com.dio.az.marketplace.registration.domain.Customer;
import com.dio.az.marketplace.registration.domain.CustomerId;
import com.dio.az.marketplace.registration.domain.CustomerRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Repository
public class JpaCustomerRepository implements CustomerRepository {

    private final CustomerEntityRepository customerEntityRepository;
    private final ApplicationEventPublisher publisher;

    public JpaCustomerRepository(CustomerEntityRepository customerEntityRepository, ApplicationEventPublisher publisher) {
        this.customerEntityRepository = customerEntityRepository;
        this.publisher = publisher;
    }

    @Override
    public Customer save(Customer customer) {
        var entity = mapper(customer);
        customerEntityRepository.save(entity);
        publisher.publishEvent(new CustomerCreated(customer.getId().toString(), customer.getName()));
        return customer;
    }

    @Override
    public List<Customer> findAll() {
        var iterable = customerEntityRepository.findAll();
        return StreamSupport.stream(iterable.spliterator(), false)
                .map(JpaCustomerRepository::mapper)
                .toList();
    }

    private static com.dio.az.marketplace.registration.infrastructure.persistence.entity.Customer mapper (Customer customer){
        com.dio.az.marketplace.registration.infrastructure.persistence.entity.Customer entity =
                new com.dio.az.marketplace.registration.infrastructure.persistence.entity.Customer();
        entity.setId(customer.getId().uuid());
        entity.setFirstName(customer.getName());
        entity.setEmail(customer.getEmail());
        return entity;
    }
    private static Customer mapper(com.dio.az.marketplace.registration.infrastructure.persistence.entity.Customer entity){
        String fullName = Optional.ofNullable(entity.getLastName())
                .map(lastName -> entity.getFirstName() + " " + lastName)
                .orElseGet(entity::getFirstName);

        return new Customer(new CustomerId(entity.getId()), fullName, entity.getEmail());
    }
}
