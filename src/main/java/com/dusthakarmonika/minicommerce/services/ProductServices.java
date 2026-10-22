package com.dusthakarmonika.minicommerce.services;

import com.dusthakarmonika.minicommerce.Interfaces.ProductOperation;
import com.dusthakarmonika.minicommerce.model.CartItem;
import com.dusthakarmonika.minicommerce.model.Customer;
import com.dusthakarmonika.minicommerce.model.product;
import com.dusthakarmonika.minicommerce.Exception.ProductNotFoundException;
import org.springframework.stereotype.Service;
import com.dusthakarmonika.minicommerce.repository.ProductRepository;
import java.util.List;


@Service
public class ProductServices implements ProductOperation {
    private final ProductRepository productRepository;

    public ProductServices(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

@Override
    public void addProduct(product Product ){
        productRepository.save(Product);
    }
    @Override
    public List<product> displayProducts(){
        return productRepository.findAll();
    }
    @Override
   public product searchProduct(String name) throws ProductNotFoundException {
       product Product = productRepository.findByProductNameIgnoreCase(name);
       if(Product != null){
        return Product;
       }
       throw new ProductNotFoundException("Product not found");
    }
    @Override
    public void updateProduct( int productId,int stock)throws ProductNotFoundException{
        product Product = productRepository.findById(productId).orElseThrow(()->new ProductNotFoundException("No Product Found"));
        Product.setStock(stock);
        productRepository.save(Product);
    }
    @Override
    public boolean removeProduct(int productID) throws ProductNotFoundException{
       if(!productRepository.existsById(productID)){
        throw new ProductNotFoundException("Product Not Found");
       }
       productRepository.deleteById(productID);
       return true;
    }



}
