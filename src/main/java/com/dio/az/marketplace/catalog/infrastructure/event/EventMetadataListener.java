package com.dio.az.marketplace.catalog.infrastructure.event;

import com.dio.az.marketplace.catalog.infrastructure.persistence.entity.EventMetadata;
import org.jspecify.annotations.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.AfterDeleteEvent;
import org.springframework.data.mongodb.core.mapping.event.AfterSaveEvent;
import org.springframework.stereotype.Component;

@Component
public class EventMetadataListener extends AbstractMongoEventListener<EventMetadata> {
    private static final Logger logger = LoggerFactory.getLogger(EventMetadataListener.class);

    @Override
    public void onAfterSave(@NonNull AfterSaveEvent<EventMetadata> event){
        logger.info("Event metadata saved via onAfterSave {}", event);
    }
    @Override
    public void onAfterDelete(@NonNull AfterDeleteEvent<EventMetadata> event){
        logger.info("Event medadata deleted via onAfterDelete {}", event);
    }

}
