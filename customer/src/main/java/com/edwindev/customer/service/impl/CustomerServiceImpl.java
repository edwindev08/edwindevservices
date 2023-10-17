package com.edwindev.customer.service.impl;

import com.edwindev.customer.controller.resources.CustomerRegistrationRequest;
import com.edwindev.customer.controller.resources.FraudCheckResponse;
import com.edwindev.customer.model.Customer;
import com.edwindev.customer.repository.CustomerRepository;
import com.edwindev.customer.service.CustomerService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public record CustomerServiceImpl(
        CustomerRepository customerRepository,
        RestTemplate restTemplate
) implements CustomerService {

    @Override
    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();
        // todo: check if email is valid
        // todo: check if email not taken
        customerRepository.saveAndFlush(customer);
        // todo: check if fraudster
        FraudCheckResponse fraudCheckResponse = restTemplate.getForObject(
                "http://localhost:8081/api/v1/fraud-check/{customerId}",
                FraudCheckResponse.class,
                customer.getId()
        );

        if (fraudCheckResponse.isFraudster()) {
            throw new IllegalStateException("Fraudulent customer");
        }
        // todo: send notifications

    }
}
