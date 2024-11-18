package com.myntra.ecommerce.controller;

import com.myntra.ecommerce.request.CustomerRegRequest;
import com.myntra.ecommerce.responce.SuccessResponse;
import com.myntra.ecommerce.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/customer")
@RestController
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/register")
    public SuccessResponse registerCustomer(@RequestBody CustomerRegRequest request){
      Integer id=  customerService.registerCustomer(request);
        return SuccessResponse.builder()
                .status(HttpStatus.CREATED)
                .message("Customer Created with id "+id)
                .data(id)
                .timeStamp(LocalDateTime.now())
                .build();
    }
}
