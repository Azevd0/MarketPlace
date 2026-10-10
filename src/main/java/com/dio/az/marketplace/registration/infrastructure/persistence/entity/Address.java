package com.dio.az.marketplace.registration.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.util.UUID;

@Entity
@Getter
@Setter
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String street, postalCode, city, state;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private Instant createdOn;

    public Address(UUID id, String street, String postalCode, String city, String state, Instant createdOn) {
        this.id = id;
        this.street = street;
        this.postalCode = postalCode;
        this.city = city;
        this.state = state;
        this.createdOn = createdOn;
    }
    public Address(){}
}
