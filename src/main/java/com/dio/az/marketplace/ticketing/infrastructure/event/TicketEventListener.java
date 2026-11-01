package com.dio.az.marketplace.ticketing.infrastructure.event;

import com.dio.az.marketplace.commom.infrastructure.event.dto.CustomerCreated;
import com.dio.az.marketplace.commom.infrastructure.event.dto.EventUpdated;
import com.dio.az.marketplace.ticketing.application.CreateCustomerUsecase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class TicketEventListener {
    private static final Logger logger = LoggerFactory.getLogger(TicketEventListener.class);
    private final CreateCustomerUsecase createCustomerUsecase;

    public TicketEventListener(CreateCustomerUsecase createCustomerUsecase) {
        this.createCustomerUsecase = createCustomerUsecase;
    }

    @EventListener
    @Async
    public void handle(CustomerCreated event){
        logger.info("CustomerCreated recived {}", event);
        createCustomerUsecase.execute(event);
    }
    @EventListener
    @Async
    public void handle(EventUpdated event){
        logger.info("EventUpdated recived {}", event);
    }


}
