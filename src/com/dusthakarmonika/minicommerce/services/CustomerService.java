package com.dusthakarmonika.minicommerce.services;

import com.dusthakarmonika.minicommerce.Interfaces.CustomerOperation;
import com.dusthakarmonika.minicommerce.model.Customer;

import java.util.List;
import com.dusthakarmonika.minicommerce.Exception.CustomerNotFoundException;
import com.dusthakarmonika.minicommerce.repository.CustomerRepository;

public class CustomerService implements CustomerOperation {
    private CustomerRepository customerRepository;
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void addCustomer(Customer customer){
       customerRepository.save(customer);
    }
    public List<Customer> DisplayCustomer(){
        return customerRepository.findAll();
    }
    public Customer searchCustomer(int customerID) throws CustomerNotFoundException{
        return customerRepository.findById(customerID).orElseThrow(() -> new CustomerNotFoundException("Customer not found"));
    }

    public boolean validEmailId(String email){
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        return email.matches(regex);
    }
    public String updateCustomerInfo(int customerId, String name, String emailId) throws CustomerNotFoundException{
       Customer customer =customerRepository.findById(customerId).orElseThrow(() -> new CustomerNotFoundException("Customer not found"));
       customer.setCustomerName(name);
       customer.setEmail(emailId);
       customerRepository.save(customer);
       return "Customer information updated successfully";
    }
    public String deleteCustomerInfo(int customerId)throws CustomerNotFoundException{
        customerRepository.findById(customerId).orElseThrow(() -> new CustomerNotFoundException("Customer not found"));
        customerRepository.deleteById(customerId);
    }



}
