package com.dusthakarmonika.minicommerce.model;

public class CartItemRequest {

    private int productId;
    private int cartId;
    private int quantity;

    // Constructors
    public CartItemRequest() {
    }

    public CartItemRequest(int productId, int cartId, int quantity) {
        this.productId = productId;
        this.cartId = cartId;
        this.quantity = quantity;
    }

    // Getters and Setters
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
