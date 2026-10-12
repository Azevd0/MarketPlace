package com.dio.az.marketplace.catalog.application;

import com.dio.az.marketplace.catalog.domain.event_domain.EventMetadataRepository;
import com.dio.az.marketplace.catalog.domain.event_domain.EventRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class BrowseShowcaseUseCase {
    private static final Logger logger = LoggerFactory.getLogger(BrowseShowcaseUseCase.class);
    private final EventRepository eventRepository;
    private final EventMetadataRepository eventMetadataRepository;

    public BrowseShowcaseUseCase(EventRepository eventRepository, EventMetadataRepository eventMetadataRepository) {
        this.eventRepository = eventRepository;
        this.eventMetadataRepository = eventMetadataRepository;
    }
}
