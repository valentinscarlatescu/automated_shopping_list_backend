package com.aslbackend.data.repository;

import com.aslbackend.data.model.Cart;
import com.aslbackend.data.model.Product;
import com.aslbackend.data.model.ProductCategory;
import com.aslbackend.data.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
    List<Cart> findByUser(User user);
}
