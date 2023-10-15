package com.edwindev.customer.controller.resources;

public record CustomerRegistrationRequest(
        String firstName,
        String lastName,
        String email
) {
}
