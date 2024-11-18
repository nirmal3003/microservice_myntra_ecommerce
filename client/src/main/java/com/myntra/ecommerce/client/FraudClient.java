package com.myntra.ecommerce.client;

import com.myntra.ecommerce.responce.SuccessResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
        value = "fraud-check-service",
        path = "/api/v1/fraud-check"
)
public interface FraudClient {
    @GetMapping("")
    public SuccessResponse checkIfFraudulent( @RequestParam("email") String email,@RequestParam(name = "phone_number") String phoneNumber);
}
