package com.myntra.ecommerce.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@Entity
public class FraudCheckHistory {
    @Id
    @GeneratedValue
    private Integer id;
    private String email;
    private long phoneNumber;
    private boolean isFraudulent;
}
