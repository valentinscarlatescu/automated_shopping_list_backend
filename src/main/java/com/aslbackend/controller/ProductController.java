package com.aslbackend.controller;

import com.aslbackend.data.model.Product;
import com.aslbackend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
