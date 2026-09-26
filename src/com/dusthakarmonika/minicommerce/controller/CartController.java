package com.dusthakarmonika.minicommerce.controller;

import com.dusthakarmonika.minicommerce.model.Cart;
import com.dusthakarmonika.minicommerce.services.CartService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import com.dusthakarmonika.minicommerce.Exception.CustomerNotFoundException;
@RestController
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/cart")
    public Cart createCart(@RequestBody Cart cart) throws CustomerNotFoundException {
        return cartService.createCart(cart);
    }
}