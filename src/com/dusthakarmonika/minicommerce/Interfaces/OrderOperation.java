package com.dusthakarmonika.minicommerce.Interfaces;

import com.dusthakarmonika.minicommerce.model.Customer;
import com.dusthakarmonika.minicommerce.services.CartService;
import com.dusthakarmonika.minicommerce.Exception.InsufficientStockException;
import com.dusthakarmonika.minicommerce.Exception.EmptyCartException;


public interface OrderOperation {
    public double  placeOrder(Customer c, int choice) throws InsufficientStockException,EmptyCartException;

}
