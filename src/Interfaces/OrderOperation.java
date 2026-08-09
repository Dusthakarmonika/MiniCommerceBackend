package Interfaces;

import model.Customer;
import services.CartService;
import Exception.InsufficientStockException;
import Exception.EmptyCartException;


public interface OrderOperation {
    public double  placeOrder(Customer c) throws InsufficientStockException,EmptyCartException;

}
