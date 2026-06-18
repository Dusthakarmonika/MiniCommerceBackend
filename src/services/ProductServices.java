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
    public product searchProduct(String name, product p){
       for(int i = 0; i < list.size(); i++){
           if(name.equalsIgnoreCase(list.get(i).getProductName())){
               p.setProductName(list.get(i).getProductName());
               p.setProductID(list.get(i).getProductID());
               p.setPrice(list.get(i).getPrice());
               p.setStock(list.get(i).getStock());
               return p;
           }
       }
       return null;

    }

}
