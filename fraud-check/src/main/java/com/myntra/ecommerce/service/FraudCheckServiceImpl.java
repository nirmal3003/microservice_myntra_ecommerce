package com.myntra.ecommerce.service;

import com.myntra.ecommerce.entity.FraudCheckHistory;
import com.myntra.ecommerce.repository.FraudCheckHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FraudCheckServiceImpl implements FraudCheckService{
    private final FraudCheckHistoryRepository fraudCheckHistoryRepository;
    @Override
    public boolean checkIfFraudulent(String email, String phoneNumber) {
       Optional<FraudCheckHistory> historyOP= fraudCheckHistoryRepository.findByEmail(email);
       if(historyOP.isPresent()){
           FraudCheckHistory fraudCheckHistory=historyOP.get();
           if(fraudCheckHistory.isFraudulent()){
               throw new RuntimeException("Customer is Fraudulent");
           }else {
               return false;
           }
       }
       fraudCheckHistoryRepository.save(FraudCheckHistory.builder()
                       .email(email)
                       .phoneNumber(Long.parseLong(phoneNumber))
                       .isFraudulent(false)
               .build());
        return false;
    }
}
