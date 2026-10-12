package com.dio.az.marketplace.catalog.domain.event_domain;

import java.util.List;

public interface EventRepository {
    List<Event> findAll();
}
