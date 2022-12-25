package ru.gb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminLoginController {

    @GetMapping("/login")
    public String listPage(){
        return "login_form";
    }

    @GetMapping("/access_denied")
    public String accessDenied() {
        return "access_denied";
    }
}
