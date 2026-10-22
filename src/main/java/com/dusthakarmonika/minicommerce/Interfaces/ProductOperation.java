package com.dusthakarmonika.minicommerce.Interfaces;

import com.dusthakarmonika.minicommerce.model.product;
import com.dusthakarmonika.minicommerce.Exception.ProductNotFoundException;
import java.util.List;

public interface ProductOperation {
    public void addProduct(product Product);
    public List<product> displayProducts();
    public product searchProduct(String name) throws ProductNotFoundException;
    public void updateProduct( int productId,int stock) throws ProductNotFoundException;
    public boolean removeProduct(int productId) throws ProductNotFoundException;
}
