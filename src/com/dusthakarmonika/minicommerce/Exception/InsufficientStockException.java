package com.dusthakarmonika.minicommerce.Exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InsufficientStockException extends Exception{
    public InsufficientStockException(String message){
        super(message);
    }
}
