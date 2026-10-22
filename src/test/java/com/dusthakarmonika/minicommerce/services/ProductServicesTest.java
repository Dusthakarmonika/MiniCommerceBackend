package com.dusthakarmonika.minicommerce.services;

import org.hibernate.annotations.TimeZoneStorage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.dusthakarmonika.minicommerce.repository.ProductRepository;
import java.util.List;
import com.dusthakarmonika.minicommerce.model.product;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.dusthakarmonika.minicommerce.Exception.ProductNotFoundException;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ProductServicesTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServices productServices;

    @Test
    public void displayProductsTest(){
    product p1 = new product(101,"Laptop",50000,35);
    product p2 = new product(102,"tv",100000,20);
    List<product> expectedProducts = List.of(p1,p2);

    when(productRepository.findAll()).
    thenReturn(expectedProducts);

    List<product> actualProducts = productServices.displayProducts();
    verify(productRepository).findAll();
    assertEquals(expectedProducts,actualProducts);

    }

    @Test
    public void displayEmptyList(){
        when(productRepository.findAll()).thenReturn(List.of());
        List<product> actualProducts = productServices.displayProducts();
        assertTrue(actualProducts.isEmpty());
    }

    @Test
    public void exceptionTest(){
        assertThrows(ProductNotFoundException.class, 
            () -> productServices.searchProduct("mobile") );
    }
}