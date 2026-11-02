package com.dio.az.marketplace.ticketing.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Entity
public class Sector {
    @Id
    private UUID id;
    private String correlationId;
    private BigDecimal price;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "sector_id")
    private List<Seat> seats= new ArrayList<>();

    public Sector(){}

    public Sector(UUID id, String correlationId, BigDecimal price, List<Seat> seats) {
        this.id = id;
        this.correlationId = correlationId;
        this.price = price;
        this.seats = seats;
    }
}
