package services;

import Interfaces.OrderOperation;
import model.CartItem;
import model.Customer;
import model.Order;
import model.product;
import Exception.InsufficientStockException;
import Exception.EmptyCartException;

import java.util.ArrayList;

public class OrderService implements OrderOperation {
    ArrayList<Order> list = new ArrayList<>();
    private CartService cartService;


    public OrderService(CartService cartService){
        this.cartService = cartService;
    }
    @Override
    public double  placeOrder(Customer c) throws InsufficientStockException,EmptyCartException  {
        ArrayList<CartItem> cart = cartService.getCartItems(c);
        double total = 0;
            for(CartItem ca : cart){
                if(ca.getProduct().getStock() < ca.getQuantity()) {
                    throw new InsufficientStockException("Insufficient Stock");
                }
                    double itemCost = ca.getProduct().getPrice() * ca.getQuantity();
                    total = total + itemCost;
                    int stock = ca.getProduct().getStock() - ca.getQuantity();
                    ca.getProduct().setStock(stock);
                }
            return total;
        }
}
