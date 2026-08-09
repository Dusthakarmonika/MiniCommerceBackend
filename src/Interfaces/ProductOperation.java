package Interfaces;

import model.product;
import Exception.ProductNotFoundException;

public interface ProductOperation {
    public void addProduct(product Product);
    public void displayProducts();
    public product searchProduct(String name) throws ProductNotFoundException;
    public boolean updateProduct( int productId,int stock);
    public boolean removeProduct(int productId);
}
