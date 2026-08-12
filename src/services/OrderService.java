package services;

import Interfaces.CartOperation;
import Interfaces.OrderOperation;
import model.*;
import Exception.InsufficientStockException;
import Exception.EmptyCartException;

import java.util.ArrayList;


public class OrderService implements OrderOperation {
    ArrayList<Order> list = new ArrayList<>();
    private CartOperation cartService;
    int choice ;
    Payment payment;


    public OrderService(CartOperation cartService){
        this.cartService = cartService;
    }
    @Override
    public double  placeOrder(Customer c, int choice) throws InsufficientStockException,EmptyCartException {
        ArrayList<CartItem> cart = cartService.getCartItems(c);
        double total = 0;
        for (CartItem ca : cart) {
            if (ca.getProduct().getStock() < ca.getQuantity()) {
                throw new InsufficientStockException("Insufficient Stock");
            }
        }
        switch (choice) {
            case 1:
                payment = new UPIPayment();
                break;
            case 2:
                payment = new CardPayment();
                break;
            case 3:
                payment = new CashOnDelivery();
                break;
        }
        payment.makePayment();
        for (CartItem ca : cart) {
            double itemCost = ca.getProduct().getPrice() * ca.getQuantity();
            total = total + itemCost;
        }
        for (CartItem ca : cart) {
            int stock = ca.getProduct().getStock() - ca.getQuantity();
            ca.getProduct().setStock(stock);
        }
            return total;
        }
}
