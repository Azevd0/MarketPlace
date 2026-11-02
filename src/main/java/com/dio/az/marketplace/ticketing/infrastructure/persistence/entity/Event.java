package com.dio.az.marketplace.ticketing.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Data
public class Event {
    @Id
    private UUID id;
    private UUID correlationId;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "event_id")
    private List<Sector> sectors = new ArrayList<>();

    public Event(UUID id, UUID correlationId, List<Sector> sectors) {
        this.id = id;
        this.correlationId = correlationId;
        this.sectors = sectors;
    }

    public Event(){}
}
