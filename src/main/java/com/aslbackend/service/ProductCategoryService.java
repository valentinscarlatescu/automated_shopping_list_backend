package com.aslbackend.service;

import com.aslbackend.data.model.ProductCategory;
import com.aslbackend.data.repository.ProductCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCategoryService {

    private final ProductCategoryRepository repository;

    @Autowired
    public ProductCategoryService(ProductCategoryRepository repository) {
        this.repository = repository;
    }

    public List<ProductCategory> findAll() {
        return repository.findAll();
    }

    public void save(ProductCategory category) {
        repository.save(category);
    }

    public void deleteById(Long id) {
        if( repository.existsById(id)){
            repository.deleteById(id);
        }
    }
}
