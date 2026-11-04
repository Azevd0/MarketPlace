package com.dio.az.marketplace.ticketing.infrastructure.persistence.repository;

import com.dio.az.marketplace.ticketing.domain.customer.CustomerId;
import com.dio.az.marketplace.ticketing.domain.event_domain.Event;
import com.dio.az.marketplace.ticketing.domain.event_domain.EventId;
import com.dio.az.marketplace.ticketing.domain.event_domain.EventRepository;
import com.dio.az.marketplace.ticketing.domain.seat_domain.Seat;
import com.dio.az.marketplace.ticketing.domain.seat_domain.SeatId;
import com.dio.az.marketplace.ticketing.domain.sector_domain.Sector;
import com.dio.az.marketplace.ticketing.infrastructure.persistence.entity.SeatLock;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

@Repository
public class WorkOfunitEventRepository implements EventRepository {
    private final EventCRUDRepository eventCRUDRepository;
    private final StringRedisTemplate redisTemplate;

    public WorkOfunitEventRepository(EventCRUDRepository eventCRUDRepository,
                                     @Qualifier("ticketingStringRedisTemplate") StringRedisTemplate redisTemplate) {

        this.eventCRUDRepository = eventCRUDRepository;
        this.redisTemplate = redisTemplate;
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
        return eventCRUDRepository.existsByCorrelationIdAndSectors_Seats_CorrelationId(eventId.id(),seatId.id());
    }

    @Override
    public boolean tryLockSeat(
            EventId eventId,
            SeatId seatId,
            CustomerId customerId) {

        String lockKey = "seat:lock:"
                + eventId.id()
                + ":"
                + seatId.id();

        String customer = customerId.id().toString();

        Boolean acquired = redisTemplate.opsForValue()
                .setIfAbsent(
                        lockKey,
                        customer,
                        Duration.ofSeconds(30)
                );

        return Boolean.TRUE.equals(acquired);
    }

}

