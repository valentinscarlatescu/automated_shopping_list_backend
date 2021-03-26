package com.aslbackend.controller;

import com.aslbackend.data.model.Product;
import com.aslbackend.data.model.User;
import com.aslbackend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private final ProductService service;

    @Autowired
    public ProductController (ProductService service){
        this.service = service;
    }

    @GetMapping("/products")
    public List<Product> findAll(){
        return service.findAll();
    }

    @PostMapping("/products")
    public void save(@RequestBody Product product){
        service.save(product);
    }

    @DeleteMapping("/products/{id}")
    public void deleteById(@PathVariable("id") Long id){
        service.deleteById(id);
    }

    @GetMapping("/products/byCategory")
    public List<Product> findByCategoryId(@RequestParam("categoryId") Long productCategoryId) {
        return service.findByCategoryId(productCategoryId);
    }
}
