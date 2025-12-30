package com.spring_security.spring_security.advices;


import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class ApiError {

    private String message;

    private HttpStatus httpStatus;

    private LocalDateTime localDateTime = LocalDateTime.now();


    public ApiError(String localizedMessage, HttpStatus httpStatus) {
    }
}
