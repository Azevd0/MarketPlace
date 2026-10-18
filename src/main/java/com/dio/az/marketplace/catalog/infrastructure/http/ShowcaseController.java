package com.dio.az.marketplace.catalog.infrastructure.http;

import com.dio.az.marketplace.catalog.application.BrowseShowcaseUseCase;
import com.dio.az.marketplace.catalog.application.dto.EventOutput;
import com.dio.az.marketplace.catalog.domain.event_domain.Event;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/showcase")
public class ShowcaseController {
    private final BrowseShowcaseUseCase browseShowcaseUseCase;

    public ShowcaseController(BrowseShowcaseUseCase browseShowcaseUseCase) {
        this.browseShowcaseUseCase = browseShowcaseUseCase;
    }
    @GetMapping
    public List<EventOutput> browseShowcase(){
        return browseShowcaseUseCase.execute();
    }
}
