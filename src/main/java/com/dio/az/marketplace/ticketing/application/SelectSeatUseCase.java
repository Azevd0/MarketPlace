package com.dio.az.marketplace.ticketing.application;

import com.dio.az.marketplace.ticketing.domain.exception.SeatAlreadyReservedException;
import com.dio.az.marketplace.ticketing.domain.exception.SeatNotFoundException;
import com.dio.az.marketplace.ticketing.domain.customer.CustomerId;
import com.dio.az.marketplace.ticketing.domain.event_domain.EventId;
import com.dio.az.marketplace.ticketing.domain.event_domain.EventRepository;
import com.dio.az.marketplace.ticketing.domain.seat_domain.SeatId;
import org.springframework.stereotype.Service;

@Service
public class SelectSeatUseCase {
    private final EventRepository eventRepository;

    public SelectSeatUseCase(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public void execute(EventId eventId, SeatId seatId, CustomerId customerId) {
        if(eventRepository.existsSeat(eventId, seatId)){
            throw new SeatNotFoundException(eventId, seatId);
        }
        boolean lock = eventRepository.tryLockSeat(eventId, seatId, customerId);

        if(!lock){
            throw new SeatAlreadyReservedException();
        }
    }
}
