package com.myntra.ecommerce.service;

import com.myntra.ecommerce.request.CustomerRegRequest;

public interface CustomerService {
    Integer registerCustomer(CustomerRegRequest request);
}
