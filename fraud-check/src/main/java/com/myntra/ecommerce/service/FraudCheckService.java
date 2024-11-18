package com.myntra.ecommerce.service;

public interface FraudCheckService {
    boolean checkIfFraudulent(String email, String phoneNumber);
}
