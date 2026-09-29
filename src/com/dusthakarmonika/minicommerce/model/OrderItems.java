package com.dusthakarmonika.minicommerce.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;


@Entity
public class OrderItems {
 
 @Id 
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private int orderItemId;

 @ManyToOne 
 private Order order;

 @ManyToOne 
 private product Product;

 private int quantity;

 public OrderItems(){

 }

public int getOrderItemId() {
    return orderItemId;
}

public Order getOrder() {
    return order;
}

public void setOrder(Order order) {
    this.order = order;
}

public product getProduct() {
    return Product;
}

public void setProduct(product Product) {
    this.Product = Product;
}

public int getQuantity() {
    return quantity;
}

public void setQuantity(int quantity) {
    this.quantity = quantity;
}

}
