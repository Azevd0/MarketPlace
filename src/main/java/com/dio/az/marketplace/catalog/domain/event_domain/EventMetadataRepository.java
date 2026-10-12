package com.dio.az.marketplace.catalog.domain.event_domain;

import java.util.Optional;

public interface EventMetadataRepository {
    Optional<EventMetadata> findByEventId(EventId eventId);
}
