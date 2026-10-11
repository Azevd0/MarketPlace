package com.dio.az.marketplace.catalog.infrastructure.persistence.repository;

import com.dio.az.marketplace.catalog.infrastructure.persistence.event.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.UUID;

@RepositoryRestResource
public interface EventEntityRepository extends CrudRepository<Event, UUID> {
}
