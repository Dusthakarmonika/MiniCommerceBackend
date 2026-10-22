package com.dusthakarmonika.minicommerce.controller;

import com.dusthakarmonika.minicommerce.model.Cart;
import com.dusthakarmonika.minicommerce.services.CartService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import com.dusthakarmonika.minicommerce.Exception.CartNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import com.dusthakarmonika.minicommerce.Exception.CustomerNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.DeleteMapping;

@RestController
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/carts")
    public Cart createCart(@Valid @RequestBody Cart cart) throws CustomerNotFoundException {
        return cartService.createCart(cart);
    }

    @GetMapping("/carts/{cartId}")
    public Cart getCartById(@PathVariable int cartId) throws CartNotFoundException {
        return cartService.getCartById(cartId);
}
    
    @DeleteMapping("/carts/{cartId}")
    public void DeleteCart(@PathVariable int cartId) throws CartNotFoundException{
        cartService.deleteCart(cartId);
    }
}