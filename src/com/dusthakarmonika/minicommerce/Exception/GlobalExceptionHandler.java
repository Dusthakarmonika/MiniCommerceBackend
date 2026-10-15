package com.dusthakarmonika.minicommerce.Exception;

import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;


@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<String> handleProductNotFound(ProductNotFoundException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(InsufficientStockException.class)
        public ResponseEntity<String> handleInsufficientStock(InsufficientStockException ex){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
        }

        @ExceptionHandler(CartNotFoundException.class)
        public ResponseEntity<String> handleCartNotFound(CartNotFoundException ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }

        @ExceptionHandler(EmptyCartException.class)
        public ResponseEntity<String> handleEmptyCart(EmptyCartException ex){
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }


