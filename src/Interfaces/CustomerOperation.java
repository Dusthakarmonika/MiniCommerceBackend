package Interfaces;

import model.Customer;
import Exception.CustomerNotFoundException;

public interface CustomerOperation {
    public void addCustomer(Customer customer);
    public Customer searchCustomer(int customerID) throws CustomerNotFoundException;
    public boolean validEmailId(String email);
    public void DisplayCustomer();
}
