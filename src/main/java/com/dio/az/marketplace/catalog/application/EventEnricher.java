package com.dio.az.marketplace.catalog.application;

import com.dio.az.marketplace.catalog.domain.event_domain.Event;
import com.dio.az.marketplace.catalog.domain.event_domain.EventMetadataRepository;
import com.dio.az.marketplace.catalog.domain.event_domain.EventRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EventEnricher {
    private static final Logger logger = LoggerFactory.getLogger(EventEnricher.class);
    private final EventRepository eventRepository;
    private final EventMetadataRepository eventMetadataRepository;


    public EventEnricher(EventRepository eventRepository, EventMetadataRepository eventMetadataRepository) {
        this.eventRepository = eventRepository;
        this.eventMetadataRepository = eventMetadataRepository;
    }
    @Async
    public Event enrich(Event event) {
        logger.info("Eriching event: {}", event);

        var metadata = eventMetadataRepository.findByEventId(event.getId());
        event.setMetadata(metadata);
        return event;
    }
}
