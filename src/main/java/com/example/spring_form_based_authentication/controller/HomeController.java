package com.example.spring_form_based_authentication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // Tells Spring this is a web controller
public class HomeController {

    @GetMapping("/login") // Maps /login URL to the login view
    public String loginPage() {
        return "login"; // Return login.html
    }

    @GetMapping("/dashboard") // Maps /dashboard URL to dashboard view
    public String dashboardPage() {
        return "dashboard"; // Return dashboard.html
    }

    @GetMapping("/logout")
    public String logoutPage(){
        return "logout";
    }
}