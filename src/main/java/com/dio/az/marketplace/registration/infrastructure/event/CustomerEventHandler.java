package com.dio.az.marketplace.registration.infrastructure.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.rest.core.annotation.HandleAfterCreate;
import org.springframework.data.rest.core.annotation.HandleAfterDelete;
import org.springframework.data.rest.core.annotation.HandleAfterSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import com.dio.az.marketplace.registration.infrastructure.persistence.entity.Customer;
import org.springframework.stereotype.Component;

@Component
@RepositoryEventHandler
public class CustomerEventHandler {

    private static final Logger logger = LoggerFactory.getLogger(CustomerEventHandler.class);

    @HandleAfterCreate
    private void handleAfterCreate(Customer customer){
        logger.warn("CustomerEventHandler#handlerAfterCreate");
    }
    @HandleAfterSave
    private void handleBeforeCreate(Customer customer){
        logger.warn("CustomerEventHandler#handlerAfterSave");
    }
    @HandleAfterDelete
    private void handleAfterDelete(Customer customer){
        logger.warn("CustomerEventHandler#handlerAfterDelete");
    }
}
