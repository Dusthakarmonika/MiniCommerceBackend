package UI;
import model.product;
import services.ProductServices;

import java.util.*;
import services.ProductServices;
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ProductServices productService = new ProductServices();
        System.out.println("------ WELCOME TO MINI E-COMMERCE ------");
        int option = 0;
        while( option <= 4) {
            System.out.println("Choose an option : ");
             option = sc.nextInt();
            switch (option) {
                case 1:
                    System.out.println("------ ADD A PRODUCT ------");
                    System.out.print("Enter the Product ID : ");
                    int productID = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Product Name : ");
                    String ProductName = sc.nextLine();
                    System.out.print("Enter Product price : ");
                    int price = sc.nextInt();
                    System.out.print("Enter the stock of the product : ");
                    int stock = sc.nextInt();
                    product Product = new product(productID, ProductName, price, stock);
                    productService.addProduct(Product);
                    System.out.println("------ YOUR PRODUCT HAS BEEN SUCCESSFULLY ADDED ------");
                    break;

                case 2:
                    System.out.println("------ VIEW THE PRODUCTS ------");
                    productService.displayProducts();
                    break;

                case 3 :
                    System.out.println("------ SEARCH PRODUCT ------");
                    System.out.print("Enter the product name : ");
                    String name = sc.nextLine();
                    product p = new product();
                    productService.searchProduct(name,p);
                    if(p == null){
                        System.out.println("------ PRODUCT NOT FOUND ------");
                    }
                    else{
                        System.out.println(p);
                    }
                    break;


                case 4:
                    System.out.println("------ EXIT ------");
                    System.out.println("Thank you for using Mini E-Commerce");
                    break;
            }
        }
        }

    }

