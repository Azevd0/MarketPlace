package com.dio.az.marketplace.ticketing.infrastructure.persistence.entity;

import jakarta.persistence.Entity;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
public class Seat {
    private UUID id;
    private String correlationId;

    public Seat(){}

    public Seat(UUID id, String correlationId) {
        this.id = id;
        this.correlationId = correlationId;
    }
}
