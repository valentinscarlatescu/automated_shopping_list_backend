package com.aslbackend.controller;

import com.aslbackend.data.model.User;
import com.aslbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final UserService service;

    @Autowired
    public UserController(UserService service) {

        this.service = service;
    }

    @GetMapping("/users")
    public List<User> findAll() {
        return service.findAll();
    }

    @PostMapping("/users")
    public User save(@RequestBody User user){
        return service.save(user);
    }

    @DeleteMapping("/users/{id}")
    public void deleteById(@PathVariable("id") Long id){
        service.deleteById(id);
    }

}
