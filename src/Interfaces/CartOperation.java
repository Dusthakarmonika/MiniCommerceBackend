package Interfaces;

import model.CartItem;
import model.Customer;
import model.product;

import java.util.ArrayList;

public interface CartOperation {
    public void addToCart(product Product, Customer customer, int quantity);
    public void displayCart(Customer customer);
    public ArrayList<CartItem> getCartItems(Customer customer);
    public void removeCartItems(Customer customer);

}
