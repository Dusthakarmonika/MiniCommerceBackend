package com.dusthakarmonika.minicommerce.repository;
import com.dusthakarmonika.minicommerce.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerRepository extends JpaRepository<Customer, Integer> {



}
