package com.aslbackend.controller;

import com.aslbackend.data.model.User;
import com.aslbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @GetMapping("/profile")
    public User getProfile() {
        User principal =
                (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return service.findById(principal.getId());
    }

    @PutMapping("/profile")
    public ResponseEntity<User> updateProfile(@Valid @RequestBody User user) {
        User principal =
                (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return ResponseEntity.ok(service.updateById(user, user.getId()));
    }

    @DeleteMapping("/users/{id}")
    public void deleteById(@PathVariable("id") Long id){
        service.deleteById(id);
    }

}
