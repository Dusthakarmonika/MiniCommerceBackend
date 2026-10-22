package com.dusthakarmonika.minicommerce.services;

import org.hibernate.annotations.TimeZoneStorage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.dusthakarmonika.minicommerce.repository.OrderRepository;
import com.dusthakarmonika.minicommerce.repository.CartRepository;
import java.util.List;
import com.dusthakarmonika.minicommerce.model.Order;
import com.dusthakarmonika.minicommerce.model.OrderItems;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.dusthakarmonika.minicommerce.Exception.CartNotFoundException;
import static org.mockito.Mockito.verify;
import java.util.Optional;
import com.dusthakarmonika.minicommerce.DTO.CreateOrderRequest;
import java.util.ArrayList;


@ExtendWith(MockitoExtension.class)
public class OrderServicesTest {
 
    @Mock
    private OrderRepository orderRepository;

    @Mock
    private CartRepository cartRepository;

    @InjectMocks
    private OrderService orderServices;

    @Test
    public void createOrderTest(){
        CreateOrderRequest request = new CreateOrderRequest();
        request.setCartId(999);
        request.setCartItemIds(new ArrayList<>(List.of(1,2)));
       when(cartRepository.findById(999)).thenReturn(Optional.empty());

       assertThrows(CartNotFoundException.class,
         () -> orderServices.createOrder(request));
    }

}
