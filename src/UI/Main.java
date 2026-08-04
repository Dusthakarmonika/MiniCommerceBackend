package UI;
import model.Customer;
import model.Order;
import model.product;
import services.*;

import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ProductServices productService = new ProductServices();
        CustomerService customerService = new CustomerService();
        CartService cartService = new CartService();
        OrderService orderService = new OrderService(cartService);
        System.out.println("------ WELCOME TO MINI E-COMMERCE ------");
        System.out.println(" OPTION 1 : Add a Product" +
                           "\n OPTION 2 : Display the Products" +
                           "\n OPTION 3 : Search the Product" +
                           "\n OPTION 4 : Update the Stock" +
                           "\n OPTION 5 : Remove the Product" +
                           "\n OPTION 6 : Add Customer" +
                           "\n OPTION 7 : Display the customer list" +
                           "\n OPTION 8 : Search for the Customer" +
                           "\n OPTION 9 : Add to Cart" +
                           "\n OPTION 10 : Display Cart Items" +
                           "\n OPTION 11 : Place Order" +
                           "\n OPTION 12 : Exit" );
        int option = 0;
        while( option < 12) {
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

                case 6 :
                    System.out.println("------ ADD A CUSTOMER ------");
                    System.out.print("Enter the Customer ID : ");
                    int customerID = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter the Customer Name : ");
                    String customerName = sc.nextLine();
                    System.out.print("Enter the Email ID of the customer : ");
                    String email = sc.nextLine();
                    Customer customer = new Customer(customerID,customerName,email );
                    customerService.addCustomer(customer);
                    System.out.println("------ CUSTOMER ADDED SUCCESSFULLY------");
                    break;

                case 7 :
                    System.out.println("------ DISPLAY CUSTOMERS ------");
                    customerService.DisplayCustomer();
                    break;

                case 8 :
                    System.out.println("------ SEARCH FOR THE CUSTOMER ------");
                    System.out.println("Enter the customer ID to be searched : ");
                    int cID = sc.nextInt();
                    Customer isFound = customerService.searchCustomer(cID);
                    if(isFound == null){
                        System.out.println("------ CUSTOMER NOT FOUND ------");
                    }
                    else{
                        System.out.println(isFound);
                    }
                    break;

                case 9:
                    System.out.println("------ADD TO CART------");
                    System.out.print("Enter the Customer ID : ");
                    int CID = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter the Product name : ");
                    String pName = sc.nextLine();
                    System.out.print("Enter the quantity of the product : ");
                    int quantity = sc.nextInt();
                    product pd = productService.searchProduct(pName);
                    Customer c = customerService.searchCustomer(CID);
                    if(pd != null && c != null) {
                        cartService.addToCart(pd, c, quantity);
                        System.out.println("------ADDED TO CART SUCCESSFULLY------");
                    }
                    else{
                        System.out.println("------INVALID PRODUCT OR CUSTOMER------");
                    }
                    break;

                case 10 :
                    System.out.println("------DISPLAY CART ITEMS------");
                    System.out.println("Enter the customer ID : ");
                    int customerId = sc.nextInt();
                    Customer cu = new Customer();
                    cu.setCustomerID(customerId);
                    cartService.displayCart(cu);

                    break;

                case 11 :
                    System.out.println("------PLACE ORDER------");
                    System.out.println("Enter the CustomerID : ");
                    double o = 0;
                    int custID = sc.nextInt();
                    Customer cust = customerService.searchCustomer(custID);
                    if(cust == null){
                        System.out.println("Customer not Found");
                    }
                    else {
                        o = orderService.placeOrder(cust);
                        cartService.displayCart(cust);
                        Order order = new Order();
                        System.out.println("OrderId : " + order.getOrderId());
                        System.out.println("Total Price : " + o);
                        System.out.println("ORDER PLACED SUCCESSFULLY");
                    }
                    cartService.removeCartItems(cust);
                   break;

                    case 12 :
                    System.out.println("------ EXIT ------");
                    System.out.println("Thank you for using Mini E-Commerce");
                    break;
            }
        }
        }

    }

