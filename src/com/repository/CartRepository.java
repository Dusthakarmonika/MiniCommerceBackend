package com.dusthakarmonika.minicommerce.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.dusthakarmonika.minicommerce.model.Cart;


public interface CartRepository extends JpaRepository<Cart, Integer> {


}
