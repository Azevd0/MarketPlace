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
public class Customer {
    @Id
    private UUID id;

    @Column(nullable = false)
    private String firstName;
    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private Instant createdOn;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Address address;

    public Customer(UUID id, String name, String lastName, String email, Instant createdOn) {
        this.id = id;
        this.firstName = name;
        this.lastName = lastName;
        this.email = email;
        this.createdOn = createdOn;
    }
    public Customer(){
    }

    @PrePersist
    public void prePersistId(){
        if(id == null){
            id = UUID.randomUUID();
        }
    }

}
