package Interfaces;

import model.CartItem;
import model.Customer;
import model.product;
import Exception.ProductNotFoundException;


import java.util.ArrayList;
import Exception.InsufficientStockException;
public interface CartOperation {
    public void addToCart(product Product, Customer customer, int quantity) throws InsufficientStockException;
    public void displayCart(Customer customer);
    public ArrayList<CartItem> getCartItems(Customer customer);
    public void removeCartItems(Customer customer);
    public void removeProductFromCart(int ProductId, int customerId)throws ProductNotFoundException;
    public void updateCartItemQuantity(int customerId, int productId, int newQuantity)throws InsufficientStockException;


}
