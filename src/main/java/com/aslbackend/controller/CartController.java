package com.aslbackend.controller;

import com.aslbackend.data.model.Cart;
import com.aslbackend.data.model.Product;
import com.aslbackend.data.model.ProductCategory;
import com.aslbackend.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CartController {

    private final CartService service;

    @Autowired
    public CartController(CartService service) {

        this.service = service;
    }

    @GetMapping("/carts")
    public List<Cart> findAll() {
        return service.findAll();
    }

    @PostMapping("/carts")
    public void save(@RequestBody Cart cart){
        service.save(cart);
    }

    @DeleteMapping("/carts/{id}")
    public void deleteById(@PathVariable("id") Long id){
        service.deleteById(id);
    }

    @GetMapping("/carts/byUser")
    public List<Cart> findByUserId(@RequestParam("userId") Long userId) {
        return service.findByUserId(userId);
    }
}
