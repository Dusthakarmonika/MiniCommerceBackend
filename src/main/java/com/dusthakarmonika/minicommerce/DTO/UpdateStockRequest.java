package com.dusthakarmonika.minicommerce.DTO;
import jakarta.validation.constraints.PositiveOrZero;

public class UpdateStockRequest {

    @PositiveOrZero
private int stock;

public UpdateStockRequest(){
}
public int getStock(){
    return stock;
}
}
