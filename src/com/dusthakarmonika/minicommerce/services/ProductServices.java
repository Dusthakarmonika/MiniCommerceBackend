package com.dusthakarmonika.minicommerce.services;

import com.dusthakarmonika.minicommerce.Interfaces.ProductOperation;
import com.dusthakarmonika.minicommerce.model.CartItem;
import com.dusthakarmonika.minicommerce.model.Customer;
import com.dusthakarmonika.minicommerce.model.product;
import com.dusthakarmonika.minicommerce.Exception.ProductNotFoundException;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
@Service
public class ProductServices implements ProductOperation {
    ArrayList<product> list = new ArrayList<>();

    public ArrayList<product> getProduct(){
        return list;
    }
@Override
    public void addProduct(product Product ){
        list.add(Product);
    }
    @Override
    public void displayProducts(){
        if(list.isEmpty()) {
            System.out.println("No product is added");
            return;
        }
        for(product p : list){
            System.out.println(p);
        }
    }
    @Override
   public product searchProduct(String name) throws ProductNotFoundException {
       for(int i = 0; i < list.size(); i++){
           if(name.equalsIgnoreCase(list.get(i).getProductName())) {
               return list.get(i);
           }
       }
       throw new ProductNotFoundException("Product not found");
    }
    @Override
    public boolean updateProduct( int productId,int stock){
        boolean isFound = false;
        for(product p : list){
            if(p.getProductID() == productId) {
                p.setStock(stock);
                isFound = true;
            }
        }
        return isFound;
    }
    @Override
    public boolean removeProduct(int productID){
        boolean isFound = false;
        for(int i = list.size()-1; i >= 0; i--){
            if(productID == list.get(i).getProductID()){
                list.remove(list.get(i));
                isFound = true;
            }
        }
        return isFound;
    }



}
