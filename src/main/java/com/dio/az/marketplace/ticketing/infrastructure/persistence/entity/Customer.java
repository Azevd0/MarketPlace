package com.dio.az.marketplace.ticketing.infrastructure.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
public class Customer {
    @Id
    private UUID id;
    private UUID correlationId;

    @NotBlank
    @Column(nullable = false)
    private String name;

    public Customer(UUID id, UUID correlationId, String name) {
        this.id = id;
        this.correlationId = correlationId;
        this.name = name;
    }
    public Customer(){}
}
