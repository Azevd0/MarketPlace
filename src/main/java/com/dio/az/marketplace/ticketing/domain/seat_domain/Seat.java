package com.dio.az.marketplace.ticketing.domain.seat_domain;

import com.dio.az.marketplace.ticketing.domain.event_domain.EventId;
import com.dio.az.marketplace.ticketing.domain.sector_domain.Sector;
import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Data
public class Seat {
    private UUID id;
    private EventId correlationId;
    private Map<Sector, List<Seat>> seats;

    public Seat(UUID id, EventId correlationId, Map<Sector, List<Seat>> seats) {
        this.id = UUID.randomUUID();
        this.correlationId = new EventId(correlationId);
        this.seats = seats;
    }
}
