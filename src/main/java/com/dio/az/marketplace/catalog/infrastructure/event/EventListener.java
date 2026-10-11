package com.dio.az.marketplace.catalog.infrastructure.event;

import com.dio.az.marketplace.catalog.infrastructure.persistence.event.Event;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostRemove;
import jakarta.persistence.PostUpdate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;

@Component
@RepositoryEventHandler
public class EventListener {
    private static final Logger logger = LoggerFactory.getLogger(EventListener.class);

    @PostPersist
    public void onEventCreated(Event event){
        logger.info("Event created via @PostPersist {}", event);
    }
    @PostUpdate
    public void onEventUpdated(Event event){
        logger.info("Event updated via @PostUpdate {}", event);
    }
    @PostRemove
    public void onEventDeleted(Event event){
        logger.info("Event deleted via @PostRemove {}", event);
    }
}
