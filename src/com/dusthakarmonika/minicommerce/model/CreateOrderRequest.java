package com.dusthakarmonika.minicommerce.model;
import java.util.List;
import java.util.ArrayList;

public class CreateOrderRequest {
private int cartId;
private ArrayList<Integer> cartItemIds;

public CreateOrderRequest(){

}

public int getCartId(){
    return cartId;
}
public void setCartId(int cartId){
    this.cartId = cartId;
}
public ArrayList<Integer> getCartItemIds(){
    return cartItemIds;
}
public void setCartIds(ArrayList<Integer> cartItemIds){
    this.cartItemIds = cartItemIds;
}
}
