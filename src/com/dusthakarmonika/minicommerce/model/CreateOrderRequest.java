package com.dusthakarmonika.minicommerce.model;

public class CreateOrderRequest {
private int cartId;

public CreateOrderRequest(){

}

public int getCartId(){
    return cartId;
}
public void setCartId(int cartId){
    this.cartId = cartId;
}
}
