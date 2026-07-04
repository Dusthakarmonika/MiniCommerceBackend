package services;

import model.CartItem;
import model.Customer;
import model.Order;

import java.util.ArrayList;

public class OrderService {
    ArrayList<Order> list = new ArrayList<>();

    public void placeOrder(Customer c,Order o){
       if(o.getCustomer().getCustomerID() == c.getCustomerID()){
           list.add(o);
       }
    }
    public void displayOrders(){
        if(list.isEmpty()){
            System.out.println("No order placed yet");
        }
        else{
            for(Order o : list) {
                System.out.println(o);
            }
        }
    }
    public Order searchOrder(int orderID){
        for(Order o : list){
            if(orderID == o.getOrderId()){
                return  o;
            }
        }
        return null;
    }
}
