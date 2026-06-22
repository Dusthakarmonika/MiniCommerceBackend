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
        System.out.println(" OPTION 1 : Add a Product" +
                           "\n OPTION 2 : Display the Products" +
                           "\n OPTION 3 : Search the Product" +
                           "\n OPTION 4 : Update the Stock" +
                           "\n OPTION 5 : Remove the Product" +
                           "\n OPTION 6 : Exit");
        int option = 0;
        while( option <= 5) {
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
                    sc.nextLine();
                    product p =  productService.searchProduct(name);
                    if(p == null){
                        System.out.println("------ PRODUCT NOT FOUND ------");
                    }
                    else{
                        System.out.println(p);
                    }
                    break;

                case 4 :
                    System.out.println("------ UPDATE THE STOCK OF THE PRODUCT ------");
                    System.out.print("Enter the updated stock : ");
                    int Stock = sc.nextInt();
                    boolean st = productService.updateProduct(Stock);
                    if(st == true){
                        System.out.println("------ PRODUCT STOCK UPDATED SUCCESSFULLY ------");
                    }
                    else{
                        System.out.println("------ SOCK UPDATE FAILED ------");
                    }
                    break;


                case 5 :
                    System.out.println("------ REMOVE THE PRODUCT ------");
                    System.out.print("Enter the product ID : ");
                    int pID = sc.nextInt();
                    boolean pro  = productService.removeProduct(pID);
                    if(pro == true){
                        System.out.println("------ PRODUCT SUCCESSFULLY REMOVED ------");
                    }
                    else{
                        System.out.println("------ PRODUCT REMOVAL FAILED ------");
                    }
                    break;

                case 6:
                    System.out.println("------ EXIT ------");
                    System.out.println("Thank you for using Mini E-Commerce");
                    break;
            }
        }
        }

    }

