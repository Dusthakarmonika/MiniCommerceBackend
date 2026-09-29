package com.dusthakarmonika.minicommerce.repository;
import com.dusthakarmonika.minicommerce.model.product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<product,Integer> {
    product findByProductNameIgnoreCase(String name);

}
