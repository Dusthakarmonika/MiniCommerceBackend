package services;

import model.product;

import java.util.ArrayList;
import java.util.Scanner;

public class ProductServices {
    ArrayList<product> list = new ArrayList<>();

    public void addProduct(product Product ){
        list.add(Product);
    }
    public void displayProducts(){
        if(list.isEmpty()) {
            System.out.println("No product is added");
        }
        for(product p : list){
            System.out.println(p);
        }
    }
    public product searchProduct(String productName) {
        for(product p : list){
            if(productName.equalsIgnoreCase(p.getProductName())){
                return p;
            }
        }
        return null;
    }
    public boolean updateProduct(int ProductID, int stock){
        for(product p : list){
            if(ProductID == p.getProductID()){
                p.setStock(stock);
                return true;
            }
        }
        return false;
    }





    }


