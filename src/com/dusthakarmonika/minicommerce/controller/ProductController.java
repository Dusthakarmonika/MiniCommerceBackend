package com.dusthakarmonika.minicommerce.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.dusthakarmonika.minicommerce.model.product;
import com.dusthakarmonika.minicommerce.services.ProductServices;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import com.dusthakarmonika.minicommerce.Exception.ProductNotFoundException;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;

@RestController
public class ProductController {

    private final ProductServices productServices;

    public ProductController(ProductServices productServices) {
        this.productServices = productServices;
    }

    @GetMapping("/products")
    public List<product> getProduct() {
        return productServices.displayProducts();
    }

    @PostMapping("/products")
    public ResponseEntity<String> addProduct(@RequestBody product Product) {
        productServices.addProduct(Product);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Product added successfully");
    }

    @GetMapping("/products/{name}")
    public product searchProduct(@PathVariable String name)
            throws ProductNotFoundException {
        return productServices.searchProduct(name);
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<String> updateStock(
            @PathVariable("id") int productId,
            @RequestBody product Product)
            throws ProductNotFoundException {

        productServices.updateProduct(productId, Product.getStock());

        return ResponseEntity.ok("Stock updated Successfully");
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<String> removeProduct(@PathVariable int id)
            throws ProductNotFoundException {

        productServices.removeProduct(id);

        return ResponseEntity.ok("Product removed successfully");
    }
}