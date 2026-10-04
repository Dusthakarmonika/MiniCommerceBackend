package com.dusthakarmonika.minicommerce.controller;
import org.springframework.web.bind.annotation.RestController;
import com.dusthakarmonika.minicommerce.services.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.dusthakarmonika.minicommerce.model.CreateOrderRequest;
import com.dusthakarmonika.minicommerce.model.Order;
import com.dusthakarmonika.minicommerce.Exception.CartNotFoundException;
import com.dusthakarmonika.minicommerce.Exception.InsufficientStockException;

@RestController
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }

    @PostMapping("/orders")
    public Order createOrder(@RequestBody CreateOrderRequest request) throws InsufficientStockException, CartNotFoundException {
        return orderService.createOrder(request);
    }


}
