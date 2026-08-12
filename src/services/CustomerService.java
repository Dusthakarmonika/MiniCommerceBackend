package services;

import Interfaces.CustomerOperation;
import model.Customer;

import java.util.ArrayList;
import Exception.CustomerNotFoundException;

public class CustomerService implements CustomerOperation {
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
    public Customer searchCustomer(int customerID) throws CustomerNotFoundException{
        for(Customer c : list){
            if(customerID == c.getCustomerID()){
                return c;
            }
        }
        throw new CustomerNotFoundException("Customer not found");
    }
    public boolean validEmailId(String email){
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        return email.matches(regex);
    }
    public void updateCustomerInfo(int customerId, String name, String emailId) throws CustomerNotFoundException{
        for(Customer c : list){
            if(c.getCustomerID() == customerId){
                c.setCustomerName(name);
                c.setEmail(emailId);
            }
        }
        throw new CustomerNotFoundException("Customer not found");
    }



}
