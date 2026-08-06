package model;

import java.util.ArrayList;

public class Order {
    private static int orderId;
    private Customer customer;
    private ArrayList<CartItem> items;
    private double totalAmount;
    static{
        orderId = 1000;
    }

    public Order(int orderId, Customer customer, ArrayList<CartItem> items, double totalAmount){
        this.orderId = orderId;
        this.customer = customer;
        this.items = items;
        this.totalAmount = totalAmount;
    }
    public Order(){

    }
    public int getOrderId(){
        return orderId++;
    }
    public void setOrderId(int orderId) {
        Order.orderId = orderId;
    }
    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public ArrayList<CartItem> getItems() {
        return items;
    }
    public void setItems(ArrayList<CartItem> items) {
        this.items = items;
    }
    public double getTotalAmount() {
        return totalAmount;
    }
    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
    public String toString(){
        return  "Order ID : " + orderId +
                "\n Customer : " + customer +
                "\n Items : " + items +
                "\n Total : " + totalAmount;

    }
}
