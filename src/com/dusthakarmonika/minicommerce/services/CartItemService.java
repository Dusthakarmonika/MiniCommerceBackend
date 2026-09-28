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
import com.dusthakarmonika.minicommerce.Exception.InsufficientStockException;
import org.springframework.stereotype.Service;

@Service
public class CartItemService  {
    
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

    public CartItem updateQuantity(Long cartItemId, int quantity) throws CartNotFoundException, InsufficientStockException {
        CartItem cartItem = cartItemRepository.findById(cartItemId).
                            orElseThrow(() -> new CartNotFoundException("Cart Item not found"));
        cartItem.setQuantity(quantity);
        int stock = cartItem.getProduct().getStock();
        if(quantity > stock){
            throw new InsufficientStockException("Insufficient stock for product: ");
        }
        return cartItemRepository.save(cartItem);
    }

    public void DeleteCart(Long cartItemId) throws CartNotFoundException {
        CartItem cartItem = cartItemRepository.findById(cartItemId).
                            orElseThrow(() -> new CartNotFoundException("Cart Item not found"));
        cartItemRepository.delete(cartItem);
    }

}

