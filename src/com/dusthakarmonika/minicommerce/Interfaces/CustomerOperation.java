package com.dusthakarmonika.minicommerce.Interfaces;

import com.dusthakarmonika.minicommerce.model.Customer;
import com.dusthakarmonika.minicommerce.Exception.CustomerNotFoundException;
import java.util.List;

public interface CustomerOperation {
    public void addCustomer(Customer customer);
    public Customer searchCustomer(int customerID) throws CustomerNotFoundException;
    public boolean validEmailId(String email);
    public List<Customer> DisplayCustomer();
    public String updateCustomerInfo(int customerId, String customerName, String EmailId)throws CustomerNotFoundException;
    public String deleteCustomerInfo(int customerId) throws CustomerNotFoundException;
}
