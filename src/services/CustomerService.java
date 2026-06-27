package services;

import model.Customer;

import java.util.ArrayList;

public class CustomerService {
    ArrayList<Customer> list = new ArrayList<>();

    public void addCustomer(Customer customer){
        list.add(customer);
    }
    public void DisplayCustomer(){
        if(list.isEmpty()){
            System.out.println("Customer list is empty");
        }
        else{
            for(Customer c : list){
                System.out.println(c);
            }
        }
    }
    public Customer searchCustomer(int customerID){
        for(Customer c : list){
            if(customerID == c.getCustomerID()){
                return c;
            }
        }
        return null;
    }



}
