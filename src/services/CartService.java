package services;

import Interfaces.CartOperation;
import model.CartItem;
import model.Customer;
import model.product;

import java.util.ArrayList;
import Exception.InsufficientStockException;

public class CartService implements CartOperation {
    ArrayList<CartItem> list = new ArrayList<>();
@Override
    public void addToCart(product Product, Customer customer, int quantity)throws InsufficientStockException {
       CartItem cartItem = new CartItem(Product,customer,quantity);
       if(cartItem.getQuantity() <= cartItem.getProduct().getStock()) {
           list.add(cartItem);
       }
       throw new InsufficientStockException("Insufficient Stock");
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
public void removeCartItems(Customer customer){
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getCustomer().equals(customer)){
                list.remove(i);
                i--;
            }
        }
}

}
