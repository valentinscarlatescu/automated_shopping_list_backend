package com.aslbackend.data.repository;

import com.aslbackend.data.model.Product;
import com.aslbackend.data.model.ProductCategory;
import com.aslbackend.data.model.ProductCount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByProductCategory(ProductCategory productCategory);

    @SuppressWarnings("JpaQlInspection")
    @Query(value = "SELECT new com.aslbackend.data.model.ProductCount(cp, count (cp)) " +
            "FROM Cart c LEFT JOIN c.cartProducts cp GROUP BY cp.id ORDER BY count (cp.id) DESC, cp.name ASC")
    List<ProductCount> findMostPopularProducts();

}
