package com.aslbackend.controller;

import com.aslbackend.data.model.ProductCategory;
import com.aslbackend.data.model.User;
import com.aslbackend.service.UserSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final UserSerivce service;

    @Autowired
    public UserController(UserSerivce service) {

        this.service = service;
    }

    @GetMapping("/users")
    public List<User> findAll() {
        return service.findAll();
    }

    @PostMapping("/users")
    public void save(@RequestBody User usr){
        service.save(usr);
    }

    @DeleteMapping("/users/{id}")
    public void deleteById(@PathVariable("id") Long id){
        service.deleteById(id);
    }

}
