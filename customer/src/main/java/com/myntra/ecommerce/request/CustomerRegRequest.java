package com.myntra.ecommerce.request;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class CustomerRegRequest {
    private String firstName;
    private String lastName;
    private String email;
    private long phoneNumber;
}
