package services;

import model.CartItem;
import model.Customer;
import model.product;

import java.util.ArrayList;

public class CartService {
    ArrayList<CartItem> list = new ArrayList<>();

    public void addToCart(product Product, Customer customer, int quantity){
       CartItem cartItem = new CartItem(Product,customer,quantity);
       list.add(cartItem);
    }

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
public ArrayList<CartItem> getCartItems(Customer customer){
    ArrayList<CartItem> items = new ArrayList<>();
        for(CartItem c : list){
            if(c.getCustomer().equals(customer)){
                items.add(c);
            }
        }
        return items;
}

}
