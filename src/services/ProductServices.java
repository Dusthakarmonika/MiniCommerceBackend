package services;

import model.product;

import java.util.ArrayList;

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
}
