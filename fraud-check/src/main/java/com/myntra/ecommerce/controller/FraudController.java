package com.myntra.ecommerce.controller;

import com.myntra.ecommerce.responce.SuccessResponse;
import com.myntra.ecommerce.service.FraudCheckService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
@RestController
@RequestMapping(path = "/api/v1/fraud-check")
@RequiredArgsConstructor
public class FraudController {
    private final FraudCheckService fraudCheckService;
    @GetMapping("")
    public SuccessResponse checkIfFraudulent(@RequestParam String email,@RequestParam(name = "phone_number") String phoneNumber){
        boolean isFraudulent=fraudCheckService.checkIfFraudulent(email,phoneNumber);
        return SuccessResponse.builder()
                .status(HttpStatus.OK)
                .message("customer is not fraudulent")
                .data(isFraudulent)
                .timeStamp(LocalDateTime.now())
                .build();
    }
}
