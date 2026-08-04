package services;

import model.CartItem;
import model.Customer;
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
    public product searchProduct(String name){
       for(int i = 0; i < list.size(); i++){
           if(name.equalsIgnoreCase(list.get(i).getProductName())){
              return list.get(i);
           }
       }
       return null;

    }

    public boolean updateProduct(int stock){
        boolean isFound = false;
        for(product p : list){
            if(stock == p.getStock()){
                p.setStock(stock);
                isFound = true;
            }
        }
        return isFound;
    }

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
