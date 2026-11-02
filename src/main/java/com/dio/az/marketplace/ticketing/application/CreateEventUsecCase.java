package com.dio.az.marketplace.ticketing.application;



import com.dio.az.marketplace.commom.infrastructure.event.dto.EventUpdated;
import com.dio.az.marketplace.ticketing.domain.event_domain.EventRepository;
import com.dio.az.marketplace.ticketing.domain.seat_domain.Seat;
import com.dio.az.marketplace.ticketing.domain.sector_domain.Sector;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CreateEventUsecCase {
    private final EventRepository eventRepository;

    public CreateEventUsecCase(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }
    public void execute(EventUpdated event){
        Map<Sector, List<Seat>> seats = event.sectors().stream()
                .collect(Collectors.toMap(
                        sector -> new Sector(sector.id(),sector.price()),
                        sector -> sector.seats().stream()
                                .map(seatDto -> new Seat(seatDto.number()))
                                .toList()
                ));

    }

}
