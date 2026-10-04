package com.dusthakarmonika.minicommerce.model;
import com.dusthakarmonika.minicommerce.model.OrderItems; 
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.CascadeType;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;

    @ManyToOne
    private Customer customer;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItems> items;

    private double totalAmount;
    
    public Order(int orderId, Customer customer, ArrayList<OrderItems> items, double totalAmount){
    this.orderId = orderId;
    this.customer = customer;
    this.items = items;
    this.totalAmount = totalAmount;
    }

    public Customer getCustomer(){
        return customer;
    }
    public void setCustomer(Customer customer){
        this.customer = customer;
    }
    public List<OrderItems> getItems(){
        return items;
    }
    public void setItems(List<OrderItems> items){
        this.items = items;
    }
    public double getTotalAmount(){
        return totalAmount;
    }
    public int getOrderId(){
        return orderId;
    }
   
}
