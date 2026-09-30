package com.dusthakarmonika.minicommerce.model;
import java.util.List;

public class CreateOrderRequest {
private int cartId;
private List<Integer> cartItemIds;

public CreateOrderRequest(){

}

public int getCartId(){
    return cartId;
}
public void setCartId(int cartId){
    this.cartId = cartId;
}
public List<Integer> getCartItemIds(){
    return cartItemIds;
}
public void setCartIds(List<Integer> cartItemIds){
    this.cartItemIds = cartItemIds;
}
}
