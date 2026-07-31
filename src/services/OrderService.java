package services;

import model.CartItem;
import model.Customer;
import model.Order;

import java.util.ArrayList;

public class OrderService {
    ArrayList<Order> list = new ArrayList<>();
    private CartService cartService;

    public OrderService(CartService cartService){
        this.cartService = cartService;
    }

    public double  placeOrder(Customer c){
        ArrayList<CartItem> cart = cartService.getCartItems(c);
        double total = 0;
        if(cart.isEmpty()){
            System.out.println("Your cart is Empty");
        }
        else{
            for(CartItem ca : cart){
                int itemCost = ca.getProduct().getPrice() * ca.getQuantity();
                total = total + itemCost;
            }
        }
        return total;
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
