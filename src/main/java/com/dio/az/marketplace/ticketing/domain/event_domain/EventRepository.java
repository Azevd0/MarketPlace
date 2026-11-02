package com.dio.az.marketplace.ticketing.domain.event_domain;

public interface EventRepository {
    void save(Event event);
}
