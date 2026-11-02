package com.dio.az.marketplace.ticketing.infrastructure.persistence.repository;

import com.dio.az.marketplace.ticketing.domain.event_domain.Event;
import com.dio.az.marketplace.ticketing.domain.event_domain.EventRepository;
import com.dio.az.marketplace.ticketing.domain.seat_domain.Seat;
import com.dio.az.marketplace.ticketing.domain.sector_domain.Sector;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PGEventRepository implements EventRepository {
    private final EventCRUDRepository eventCRUDRepository;

    public PGEventRepository(EventCRUDRepository eventCRUDRepository) {
        this.eventCRUDRepository = eventCRUDRepository;
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

}

