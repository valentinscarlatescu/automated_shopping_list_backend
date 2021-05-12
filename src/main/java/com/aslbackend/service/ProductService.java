package com.aslbackend.service;

import com.aslbackend.data.model.Product;
import com.aslbackend.data.model.ProductCategory;
import com.aslbackend.data.model.ProductCount;
import com.aslbackend.data.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductService {

    private final ProductRepository repository;
    private final ProductCategoryService productCategoryService;

    @Autowired
    public ProductService(ProductRepository repository, ProductCategoryService productCategoryService) {
        this.repository = repository;
        this.productCategoryService = productCategoryService;
    }

    public List<Product> findAll() {
        return repository.findAll();
    }

    public void save(Product product) {
        repository.save(product);
    }

    public void deleteById(Long id) {
        if( repository.existsById(id)){
            repository.deleteById(id);
        }
    }

    public List<Product> findByCategoryId(Long productCategoryId){
        ProductCategory productCategory = productCategoryService.findById(productCategoryId);
        return repository.findByProductCategory(productCategory);
    }

    public List<ProductCount> findMostPopularProducts() {
        return repository.findMostPopularProducts();
    }

}
