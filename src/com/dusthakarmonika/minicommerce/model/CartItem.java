package com.dusthakarmonika.minicommerce.model;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private product Product;

    @ManyToOne
    @JsonBackReference
    private Cart cart;

    private int quantity;

    public CartItem(product Product, Cart cart, int quantity){
        this.Product = Product;
        this.cart = cart;
        this.quantity = quantity;
    }
    public CartItem(){

    }
    public product getProduct(){
        return Product;
    }
    public Cart getCart(){
        return cart;
    }
    public int getQuantity(){
        return quantity;
    }
    public void setProduct(product Product){
        this.Product = Product;
    }
    public void setCart(Cart cart){
        this.cart = cart;
    }
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
    public String toString(){
        return "  Product : " + Product.getProductName() +
                "\n Cart : " + cart.getCartId() +
                "\n Quantity : " + quantity;
    }
}
