package com.dio.az.marketplace.ticketing.domain.event_domain;

import com.dio.az.marketplace.ticketing.domain.seat_domain.Seat;
import com.dio.az.marketplace.ticketing.domain.sector_domain.Sector;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Event {
    private UUID id;
    private EventId correlationId;
    private Map<Sector, List<Seat>> seats;
}
