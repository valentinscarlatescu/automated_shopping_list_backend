package com.aslbackend.controller;

import com.aslbackend.data.model.ProductCategory;
import com.aslbackend.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductCategoryController {

    private final ProductCategoryService service;

    @Autowired
    public ProductCategoryController(ProductCategoryService service){
        this.service = service;
    }

    @GetMapping("/product_categories")
    public List<ProductCategory> findAll() {
        return service.findAll();
    }

    @PostMapping("/product_categories")
    public void save(@RequestBody ProductCategory category){
        service.save(category);
    }

    @DeleteMapping("/product_categories/{id}")
    public void deleteById(@PathVariable("id") Long id){
        service.deleteById(id);
    }

}
