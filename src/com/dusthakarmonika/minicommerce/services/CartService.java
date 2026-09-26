package com.dusthakarmonika.minicommerce.services;

import com.dusthakarmonika.minicommerce.repository.CartRepository;
import com.dusthakarmonika.minicommerce.model.Cart;
import org.springframework.stereotype.Service;
import com.dusthakarmonika.minicommerce.repository.CustomerRepository;
import com.dusthakarmonika.minicommerce.Exception.CustomerNotFoundException;
import com.dusthakarmonika.minicommerce.model.Customer;

@Service
public class CartService {

    private final CartRepository cartRepository;
    private final CustomerRepository customerRepository;

    public CartService(CartRepository cartRepository, CustomerRepository customerRepository) {
        this.cartRepository = cartRepository;
        this.customerRepository = customerRepository;
    }

    public Cart createCart(Cart cart) throws CustomerNotFoundException {
       Customer customer =  customerRepository.findById(cart.getCustomer().getCustomerID())
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found"));
                 Cart newCart = new Cart();
        newCart.setCustomer(customer);
        return cartRepository.save(newCart);
    }

    public Cart getCartById(int cartId) {
        return cartRepository.findById(cartId).orElse(null);
    }

    public void deleteCart(int cartId) {
        cartRepository.deleteById(cartId);
    }
}
