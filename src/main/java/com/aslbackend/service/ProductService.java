package com.aslbackend.service;

import com.aslbackend.data.model.Product;
import com.aslbackend.data.model.User;
import com.aslbackend.data.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductService {

    private final ProductRepository repository;

    @Autowired
    public ProductService(ProductRepository repository) {
        this.repository = repository;
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
}
