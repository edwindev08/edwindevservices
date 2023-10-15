package com.edwindev.customer.controller;

import com.edwindev.customer.builders.CustomerRequestBuilder;
import com.edwindev.customer.service.impl.CustomerServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;



@ExtendWith(MockitoExtension.class)
public class CustomerControllerTest {

    @Mock
    private CustomerServiceImpl customerService;
    private CustomerController customerController;

    @BeforeEach
    void setUp() {
        customerController = new CustomerController(customerService);
    }

    @Test
    void shouldRegisterACustomerWithValidRequest() {
        var request = new CustomerRequestBuilder().build();

        customerController.registerCustomer(request);

        verify(customerService, times(1)).registerCustomer(request);
    }
}
