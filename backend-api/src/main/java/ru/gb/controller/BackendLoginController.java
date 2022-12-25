package ru.gb.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("v1")
@RestController
public class BackendLoginController {

    @GetMapping("/login")
    public User login(Authentication auth) {
        return (User) auth.getPrincipal();
    }
}
