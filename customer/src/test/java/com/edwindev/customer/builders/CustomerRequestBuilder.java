package com.edwindev.customer.builders;

import com.edwindev.customer.controller.resources.CustomerRegistrationRequest;

public class CustomerRequestBuilder {

    public CustomerRegistrationRequest build() {
        return new CustomerRegistrationRequest("John",
                "Doe",
                "johndois@edwindev.com");
    }
}
