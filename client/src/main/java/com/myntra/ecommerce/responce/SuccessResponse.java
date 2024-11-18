package com.myntra.ecommerce.responce;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class SuccessResponse {
    private HttpStatus status;
    private String message;
    private String token;
    private Object data;
    private LocalDateTime timeStamp;
}
