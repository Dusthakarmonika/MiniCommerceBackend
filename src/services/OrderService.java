package services;

import model.CartItem;
import model.Customer;
import model.Order;
import model.product;

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
                if(ca.getQuantity() > ca.getProduct().getStock()){
                    System.out.println("There is no enough Stock");
                }
                else {
                    int itemCost = ca.getProduct().getPrice() * ca.getQuantity();
                    total = total + itemCost;
                }
            }
            for(CartItem ca : cart){
                int stock = ca.getProduct().getStock() - ca.getQuantity();
               ca.getProduct().setStock(stock);

            }
        }
        return total;
    }



}
