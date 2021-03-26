package com.aslbackend.data.repository;

import com.aslbackend.data.model.Product;
import com.aslbackend.data.model.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByProductCategory(ProductCategory productCategory);
}
