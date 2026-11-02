package com.dio.az.marketplace.ticketing.domain.customer;

import lombok.Data;

import java.util.UUID;
@Data
public class Customer {
    private UUID id;
    private CustomerId correlationId;
    private String name;

    public Customer(String correlationId, String name) {
        this.id = UUID.randomUUID();
        this.correlationId = new CustomerId(correlationId);
        this.name = name;
    }
}
