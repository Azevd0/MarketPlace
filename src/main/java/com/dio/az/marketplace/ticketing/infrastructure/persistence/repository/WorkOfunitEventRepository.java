package com.dio.az.marketplace.ticketing.infrastructure.persistence.repository;

import com.dio.az.marketplace.ticketing.domain.customer.CustomerId;
import com.dio.az.marketplace.ticketing.domain.event_domain.Event;
import com.dio.az.marketplace.ticketing.domain.event_domain.EventId;
import com.dio.az.marketplace.ticketing.domain.event_domain.EventRepository;
import com.dio.az.marketplace.ticketing.domain.seat_domain.Seat;
import com.dio.az.marketplace.ticketing.domain.seat_domain.SeatId;
import com.dio.az.marketplace.ticketing.domain.sector_domain.Sector;
import com.dio.az.marketplace.ticketing.infrastructure.persistence.entity.SeatLock;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;

@Repository
public class WorkOfunitEventRepository implements EventRepository {
    private final EventCRUDRepository eventCRUDRepository;
    private final RedisSeatLockRepository redisSeatLockRepository;


    public WorkOfunitEventRepository(EventCRUDRepository eventCRUDRepository, RedisSeatLockRepository redisSeatLockRepository) {
        this.eventCRUDRepository = eventCRUDRepository;
        this.redisSeatLockRepository = redisSeatLockRepository;
    }

    @Override
    public void save(Event event) {

        var sectors = event.getSeats().entrySet().stream()
                .map( entry -> {

                    Sector domainSector = entry.getKey();
                    List<Seat> domainSeats = entry.getValue();

                    var seats = domainSeats.stream()
                            .map(s -> new com.dio.az.marketplace.ticketing.infrastructure.persistence.entity.Seat(
                                    s.getId(),
                                    s.getCorrelationId().id()
                            ))
                            .toList();

                    return new com.dio.az.marketplace.ticketing.infrastructure.persistence.entity.Sector(
                            domainSector.getId(),
                            domainSector.getCorrelationId().id(),
                            domainSector.getPrice(),
                            seats
                    );
                })
                .toList();

        var entity = new com.dio.az.marketplace.ticketing.infrastructure.persistence.entity.Event(
                event.getId(),
                event.getCorrelationId().id(),
                sectors
        );

        eventCRUDRepository.save(entity);
    }

    @Override
    public boolean existsSeat(EventId eventId, SeatId seatId) {
        return eventCRUDRepository.existsCorrelationIdAndSectors_Seats_CorrelationId(eventId.id(),seatId.id());
    }

    @Override
    public boolean tryLockSeat(EventId eventId, SeatId seatId, CustomerId customerId) {
        String lockId = eventId.id().toString() + ":" + seatId.id();

        if(redisSeatLockRepository.existsById(lockId)){
            return false;
        }
        var lock = new SeatLock(lockId, customerId.id().toString(), Instant.now());
        redisSeatLockRepository.save(lock);
        return true;
    }

}

