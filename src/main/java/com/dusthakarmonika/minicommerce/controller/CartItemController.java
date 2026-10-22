package com.dusthakarmonika.minicommerce.controller;
import org.springframework.web.bind.annotation.RestController;
import com.dusthakarmonika.minicommerce.services.CartItemService;

import com.dusthakarmonika.minicommerce.Exception.CartNotFoundException;

import com.dusthakarmonika.minicommerce.model.CartItem;
import com.dusthakarmonika.minicommerce.model.Cart;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import com.dusthakarmonika.minicommerce.model.CartItemRequest;
import com.dusthakarmonika.minicommerce.Exception.CartNotFoundException;
import com.dusthakarmonika.minicommerce.Exception.ProductNotFoundException;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.dusthakarmonika.minicommerce.DTO.UpdateCartItemRequest;
import com.dusthakarmonika.minicommerce.Exception.InsufficientStockException;
import org.springframework.web.bind.annotation.DeleteMapping;
import java.util.List;
import java.util.ArrayList;


@RestController
public class CartItemController {

    private final CartItemService cartItemService;

    public CartItemController(CartItemService cartItemService) {
        this.cartItemService = cartItemService;
    }

    @PostMapping("/cart-items")
    public CartItem addToCart(@RequestBody CartItemRequest request) throws CartNotFoundException, ProductNotFoundException {
        return cartItemService.addToCart(request.getProductId(), request.getCartId(), request.getQuantity());
    }

    @PutMapping("/cart-items/{cartItemId}")
    public CartItem updateQuantity(@PathVariable int cartItemId, @RequestBody UpdateCartItemRequest request) throws CartNotFoundException, InsufficientStockException {
        return cartItemService.updateQuantity(cartItemId, request.getQuantity());
    }

    @DeleteMapping("/cart-items/{cartItemId}")
    public void DeleteCart(@PathVariable int cartItemId) throws CartNotFoundException {
        cartItemService.DeleteCart(cartItemId);
    }
    @GetMapping("/cart-items")
    public List<CartItem> getAllCartItems() throws CartNotFoundException {
        return cartItemService.getCartItems();
    }
}
