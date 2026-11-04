package com.dio.az.marketplace.ticketing.infrastructure.http;

import com.dio.az.marketplace.ticketing.application.SelectSeatUseCase;
import com.dio.az.marketplace.ticketing.domain.customer.CustomerId;
import com.dio.az.marketplace.ticketing.domain.event_domain.EventId;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ticketing/events/{eventId}/seats")
public class SeatSelectorController {
    private final SelectSeatUseCase selectSeatUseCase;

    public SeatSelectorController(SelectSeatUseCase selectSeatUseCase) {
        this.selectSeatUseCase = selectSeatUseCase;
    }
    @PostMapping("/select")
    @ResponseStatus(HttpStatus.CREATED)
    public void selectSeat(@PathVariable String eventId,
                           @RequestBody SeatSelectionRequest request,
                           @RequestHeader("X-CUSTOMER-ID") String customerId){
        selectSeatUseCase.execute(new EventId(eventId), request.toInput(), new CustomerId(customerId));
    }
}
