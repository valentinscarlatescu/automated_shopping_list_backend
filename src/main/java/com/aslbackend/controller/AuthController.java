package com.aslbackend.controller;

import com.aslbackend.controller.request.LoginBody;
import com.aslbackend.controller.request.RegisterBody;
import com.aslbackend.data.model.User;
import com.aslbackend.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    private final AuthService service;

    @Autowired
    public AuthController(AuthService service) {
        this.service = service;
    }

    @PostMapping("/auth/register")
    public User register(@RequestBody RegisterBody body) {
        return service.register(body);
    }

    @PostMapping("/auth/login")
    public User login(@RequestBody LoginBody body) {
        return service.login(body);
    }

    @PostMapping("/auth/logout")
    public void logout() {
        service.logout();
    }

}
