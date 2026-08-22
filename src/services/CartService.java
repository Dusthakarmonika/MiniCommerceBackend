package services;

import Interfaces.CartOperation;
import model.CartItem;
import model.Customer;
import model.product;

import java.util.ArrayList;
import Exception.InsufficientStockException;
import Exception.ProductNotFoundException;
import Exception.CustomerNotFoundException;


public class CartService implements CartOperation {
    ArrayList<CartItem> list = new ArrayList<>();
@Override
    public void addToCart(product Product, Customer customer, int quantity)throws InsufficientStockException {
       int presentStock = 0;
           for(CartItem c : list) {
               if (c.getProduct().equals(Product) && c.getCustomer().equals(customer)) {
                   presentStock = c.getQuantity() + quantity;
                   if (presentStock > c.getProduct().getStock()) {
                       throw new InsufficientStockException("Insufficient Stock");
                   }
                   c.setQuantity(presentStock);
                   return;
               }
               if(c.getQuantity() > c.getProduct().getStock()){
                   throw new InsufficientStockException("Insufficient Stock");
               }
           }
    CartItem cartItem = new CartItem(Product,customer,quantity);
           list.add(cartItem);
    }
    @Override
    public void displayCart(Customer customer){
        if(list.isEmpty()){
                System.out.println("No item is added");
            }
            else{
                for(CartItem c : list){
                    if(c.getCustomer().getCustomerID() == customer.getCustomerID()) {
                        System.out.println(c);
                    }
                    }
                }
            }
    @Override
public ArrayList<CartItem> getCartItems(Customer customer){
    ArrayList<CartItem> items = new ArrayList<>();

        for(CartItem c : list){
            if(c.getCustomer().equals(customer)){
                items.add(c);
            }
        }
        return items;
}
    @Override
public void removeCartItems(Customer customer) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getCustomer().equals(customer)) {
                list.remove(i);
                i--;
            }
        }
    }
    public void removeProductFromCart(int productId,int customerId)throws ProductNotFoundException {
    if(list.isEmpty()){
        System.out.println("list is empty");
        return;
    }
    for(int i = 0; i < list.size(); i++){
        if(list.get(i).getProduct().getProductID() == productId &&
           list.get(i).getCustomer().getCustomerID() == customerId){
            list.remove(i);
            System.out.println("Product removed from cart");
        }
    }
    throw new ProductNotFoundException("Product not found");
    }
    public void updateCartItemQuantity(int customerId, int productId, int newQuantity) throws InsufficientStockException {
        for (CartItem c : list) {
            if (c.getProduct().getProductID() == productId &&
                    c.getCustomer().getCustomerID() == customerId &&
                    c.getProduct().getStock() >= newQuantity) {
                c.setQuantity(newQuantity);
                return;
            }
            throw new InsufficientStockException("Insufficient Stock in the cart");
        }
        throw new InsufficientStockException("Product not found in the cart");
    }

}
