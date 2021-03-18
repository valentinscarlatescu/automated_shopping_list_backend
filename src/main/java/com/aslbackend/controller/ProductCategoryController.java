package com.aslbackend.controller;

import com.aslbackend.data.model.ProductCategory;
import com.aslbackend.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductCategoryController {
    private final ProductCategoryService service;

    @Autowired
    public ProductCategoryController(ProductCategoryService service){
        this.service = service;
    }

    @GetMapping
    public List<ProductCategory> findAll() {
        return service.findAll();
    }
}
