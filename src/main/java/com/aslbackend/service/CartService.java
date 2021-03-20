package com.aslbackend.service;

import com.aslbackend.data.model.Cart;
import com.aslbackend.data.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
    private final CartRepository repository;

    @Autowired
    public CartService(CartRepository repository) {
        this.repository = repository;
    }

    public List<Cart> findAll() {
        return repository.findAll();
    }
    //Nothing
}
