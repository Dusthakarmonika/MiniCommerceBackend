package com.dusthakarmonika.minicommerce.services;

import com.dusthakarmonika.minicommerce.Interfaces.CartOperation;
import com.dusthakarmonika.minicommerce.model.CartItem;
import com.dusthakarmonika.minicommerce.model.product;

import java.util.ArrayList;
import com.dusthakarmonika.minicommerce.Exception.InsufficientStockException;
import com.dusthakarmonika.minicommerce.Exception.ProductNotFoundException;
import com.dusthakarmonika.minicommerce.Exception.CustomerNotFoundException;
import com.dusthakarmonika.minicommerce.model.Cart;
import com.dusthakarmonika.minicommerce.repository.CartItemRepository;
import com.dusthakarmonika.minicommerce.repository.CartRepository;
import com.dusthakarmonika.minicommerce.repository.ProductRepository;

import com.dusthakarmonika.minicommerce.Exception.CartNotFoundException;
import com.dusthakarmonika.minicommerce.Exception.ProductNotFoundException;

import org.springframework.stereotype.Service;

@Service
public class CartItemService  {
    ArrayList<CartItem> list = new ArrayList<>();
    private final CartItemRepository cartItemRepository;
    private final CartRepository cartRepository;
    private final ProductRepository productRepository;

    public CartItemService(CartItemRepository cartItemRepository, CartRepository cartRepository, ProductRepository productRepository) {
        this.cartItemRepository = cartItemRepository;
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
    }


   public CartItem addToCart(int ProductId, int CartId, int quantity)throws CartNotFoundException, ProductNotFoundException {
       Cart cart = cartRepository.findById(CartId).orElseThrow(() -> new CartNotFoundException("Cart not found"));
       product product = productRepository.findById(ProductId).orElseThrow(() -> new ProductNotFoundException("Product not found"));
       CartItem cartItem = new CartItem(product, cart, quantity);
       return cartItemRepository.save(cartItem);
    }

public ArrayList<CartItem> getCartItems(Cart cart){
    ArrayList<CartItem> items = new ArrayList<>();

        for(CartItem c : list){
            if(c.getCart().equals(cart)){
                items.add(c);
            }
        }
        return items;
}

public void removeCartItems(Cart cart){ 
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getCart().equals(cart)) {
                list.remove(i);
                i--;
            }
        }
    }
    public void removeProductFromCart(int productId,int CartId)throws ProductNotFoundException {
    if(list.isEmpty()){
        System.out.println("list is empty");
        return;
    }
    for(int i = 0; i < list.size(); i++){
        if(list.get(i).getProduct().getProductID() == productId &&
           list.get(i).getCart().getCartId() == CartId){
            list.remove(i);
            System.out.println("Product removed from cart");
        }
    }
    throw new ProductNotFoundException("Product not found");
    }
    public void updateCartItemQuantity(int CartId, int productId, int newQuantity) throws InsufficientStockException {
        for (CartItem c : list) {
            if (c.getProduct().getProductID() == productId &&
                    c.getCart().getCartId() == CartId &&
                    c.getProduct().getStock() >= newQuantity) {
                c.setQuantity(newQuantity);
                return;
            }
            throw new InsufficientStockException("Insufficient Stock in the cart");
        }
        throw new InsufficientStockException("Product not found in the cart");
    }

}
