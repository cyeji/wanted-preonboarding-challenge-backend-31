package com.wanted.ecommerce.infrastructure.config.error;

import com.wanted.ecommerce.infrastructure.config.error.exception.ProductException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProductException.class)
    public ResponseEntity handleProductNotFound(ProductException ex) {
        return ResponseEntity.badRequest().body(
            ErrorResponse.of("RESOURCE_NOT_FOUND", ex.getMessage())
        );
    }

}

