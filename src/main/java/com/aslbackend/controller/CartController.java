package com.aslbackend.controller;

import com.aslbackend.data.model.Cart;
import com.aslbackend.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CartController {

    private final CartService service;

    @Autowired
    public CartController(CartService service) {

        this.service = service;
    }

    @GetMapping
    public List<Cart> findAll() {
        return service.findAll();
    }
}
