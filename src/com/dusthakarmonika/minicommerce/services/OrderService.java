package com.dusthakarmonika.minicommerce.services;

import org.springframework.stereotype.Service;
import com.dusthakarmonika.minicommerce.repository.OrderRepository;
import com.dusthakarmonika.minicommerce.repository.CartRepository;
import com.dusthakarmonika.minicommerce.model.Cart;
import com.dusthakarmonika.minicommerce.Exception.CartNotFoundException;



import java.util.ArrayList;

@Service 
public class OrderService{
    private final OrderRepository orderRepository;
    private final CartRepository cartRepository;

    public OrderService(OrderRepository orderRepository,CartRepository cartRepository){
        this.orderRepository = orderRepository;
        this.cartRepository = cartRepository;
    }

    public Cart findCartId(int cartId) throws CartNotFoundException{
        return cartRepository.findById(cartId)
                             .orElseThrow(() -> new CartNotFoundException("Cart not found"));
        
    }
    public void validateCartItems(Cart cart){
        if(cart.getCartItems().isEmpty()){
            throw new RuntimeException("cart is empty");
        }
    }


}



