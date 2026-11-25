package com.dio.az.marketplace.registration.infrastructure.persistence.entity.projection;

import com.dio.az.marketplace.registration.infrastructure.persistence.entity.Customer;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "excerpt", types = Customer.class)
public interface CustomerExcerpt {
    String getFirstName();

    String getLastName();

    AddressExcerpt getAddress();

    interface AddressExcerpt {
        String getStreet();

        String getPostalCode();

        String getCity();

        String getState();
    }
}
