package com.edwindev.customer.service;

import com.edwindev.customer.controller.resources.CustomerRegistrationRequest;

public interface CustomerService {

    void registerCustomer(CustomerRegistrationRequest request);

}
