package com.spring_security.spring_security.advices;


import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<ApiError> authenticationExceptionHandler(AuthenticationException exception){
        ApiError apiError = new ApiError(exception.getLocalizedMessage() , HttpStatus.UNAUTHORIZED);

        return new ResponseEntity<>(apiError , HttpStatus.UNAUTHORIZED);
    }
}
