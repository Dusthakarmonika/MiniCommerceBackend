package com.dusthakarmonika.minicommerce.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.dusthakarmonika.minicommerce.model.product;
import com.dusthakarmonika.minicommerce.services.ProductServices;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class ProductController{
    private final ProductServices productServices;

    public ProductController(ProductServices productServices){
        this.productServices = productServices;
    }
    @GetMapping("/products")
    public ArrayList<product> getProduct(){
        return productServices.getProduct();
    }
    @PostMapping("/products")
    public String addProduct(@RequestBody product Product){
        productServices.addProduct(Product);
        return "Product added successfully";
    }
}