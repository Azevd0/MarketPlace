package com.dio.az.marketplace.ticketing.domain.event_domain;

import com.dio.az.marketplace.ticketing.domain.customer.CustomerId;
import com.dio.az.marketplace.ticketing.domain.seat_domain.SeatId;

public interface EventRepository {
    void save(Event event);
    boolean existsSeat(EventId eventId, SeatId seatId);
    boolean tryLockSeat(EventId eventId, SeatId seatId, CustomerId customerId);
}
