package com.dusthakarmonika.minicommerce.Interfaces;

import com.dusthakarmonika.minicommerce.model.Customer;
import com.dusthakarmonika.minicommerce.Exception.CustomerNotFoundException;

public interface CustomerOperation {
    public void addCustomer(Customer customer);
    public Customer searchCustomer(int customerID) throws CustomerNotFoundException;
    public boolean validEmailId(String email);
    public void DisplayCustomer();
    public void updateCustomerInfo(int CustomerId, String customerName, String EmailId)throws CustomerNotFoundException;
    public void deleteCustomerInfo(int customerId) throws CustomerNotFoundException;
}
