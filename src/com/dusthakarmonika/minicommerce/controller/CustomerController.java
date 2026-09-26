package com.dusthakarmonika.minicommerce.controller;

import com.dusthakarmonika.minicommerce.model.Customer;
import com.dusthakarmonika.minicommerce.services.CustomerService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import com.dusthakarmonika.minicommerce.Exception.CustomerNotFoundException;
import java.util.List;


@RestController
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    public List<Customer> getCustomer(){
        return customerService.DisplayCustomer();
    }
    @PostMapping("/customers")
    public ResponseEntity<String> addCustomer(@RequestBody Customer customer){
        customerService.addCustomer(customer);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Customer added successfully");
    }
    @PutMapping("/customers/{id}")
    public ResponseEntity<String> updateCustomerInfo(@PathVariable("id") int customerId, @RequestBody Customer customer) throws CustomerNotFoundException {
        customerService.updateCustomerInfo(customerId,customer.getCustomerName(),customer.getEmail());
        return ResponseEntity.ok("Customer information updated successfully");
    }
    @DeleteMapping("/customers/{id}")
    public ResponseEntity<String> deleteCustomerInfo(@PathVariable("id") int customerId) throws CustomerNotFoundException {
        customerService.deleteCustomerInfo(customerId);
        return ResponseEntity.ok("Customer information deleted successfully");
    }
    @GetMapping("/customers/{id}")
public ResponseEntity<Customer> getCustomerById(
        @PathVariable("id") int customerId) throws CustomerNotFoundException {

    Customer customer = customerService.searchCustomer(customerId);

    return ResponseEntity.ok(customer);
}
}
