package com.dio.az.marketplace.catalog.application;

import com.dio.az.marketplace.catalog.domain.event_domain.Event;
import com.dio.az.marketplace.catalog.domain.event_domain.EventMetadataRepository;
import com.dio.az.marketplace.catalog.domain.event_domain.EventRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrowseShowcaseUseCase {
    private static final Logger logger = LoggerFactory.getLogger(BrowseShowcaseUseCase.class);
    private final EventRepository eventRepository;
    private final EventMetadataRepository eventMetadataRepository;

    public BrowseShowcaseUseCase(EventRepository eventRepository, EventMetadataRepository eventMetadataRepository) {
        this.eventRepository = eventRepository;
        this.eventMetadataRepository = eventMetadataRepository;
    }
    public List<Event> execute(){
        var events = eventRepository.findAll().stream().map(event -> {
                    logger.info("Eriching event: {}", event);

                    var metadata = eventMetadataRepository.findByEventId(event.getId());
                    event.setMetadata(metadata);
                    return event;
         }).toList();

        return events;
    }
}
