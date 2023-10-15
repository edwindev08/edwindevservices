package com.edwindev.customer.service.impl;

import com.edwindev.customer.controller.resources.CustomerRegistrationRequest;
import com.edwindev.customer.model.Customer;
import com.edwindev.customer.repository.CustomerRepository;
import com.edwindev.customer.service.CustomerService;
import org.springframework.stereotype.Service;

@Service
public record CustomerServiceImpl(CustomerRepository customerRepository) implements CustomerService {

    @Override
    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();
        // todo: check if email is valid
        // todo: check if email not taken
        customerRepository.save(customer);

    }
}
