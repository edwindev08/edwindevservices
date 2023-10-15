package com.edwindev.customer.service;

import com.edwindev.customer.builders.CustomerRequestBuilder;
import com.edwindev.customer.model.Customer;
import com.edwindev.customer.repository.CustomerRepository;
import com.edwindev.customer.service.impl.CustomerServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceImplTest {

    @Mock
    private CustomerRepository customerRepository;

    private CustomerServiceImpl customerService;

    @BeforeEach
    void setUp() {
        this.customerService = new CustomerServiceImpl(customerRepository);
    }

    @Test
    void shouldSaveCustomerWithProperData() {
        var request = new CustomerRequestBuilder().build();
        var customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();

        customerService.registerCustomer(request);

        verify(customerRepository, times(1)).save(customer);
    }
}
