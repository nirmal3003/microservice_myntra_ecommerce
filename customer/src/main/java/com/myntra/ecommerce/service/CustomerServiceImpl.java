package com.myntra.ecommerce.service;

import com.myntra.ecommerce.client.FraudClient;
import com.myntra.ecommerce.entity.Customer;
import com.myntra.ecommerce.repository.CustomerRepository;
import com.myntra.ecommerce.request.CustomerRegRequest;
import com.myntra.ecommerce.responce.SuccessResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService{
    private final CustomerRepository customerRepository;
    private final RestTemplate restTemplate;
    private final FraudClient fraudClient;
    @Override
    public Integer registerCustomer(CustomerRegRequest request) {
//       SuccessResponse response= restTemplate.getForObject("http://FRAUD-CHECK-SERVICE/api/v1/fraud-check?email=v@v.com&phone_number=123456789"
//               ,SuccessResponse.class);
        SuccessResponse response = fraudClient.checkIfFraudulent(request.getEmail(), request.getPhoneNumber() + "");
        if(!(Boolean)response.getData()) {
            return customerRepository.save(Customer.builder()
                    .firstName(request.getFirstName())
                    .lastName(request.getLastName())
                    .email(request.getEmail())
                    .phoneNumber(request.getPhoneNumber())
                    .build()).getId();
        }
        throw new RuntimeException("Customer is fraudulent, registration unsuccessfully");
    }
}
