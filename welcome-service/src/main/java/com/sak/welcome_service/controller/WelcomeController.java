package com.sak.welcome_service.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController {

    @GetMapping("/")
    public ModelAndView welcome() {
        return new ModelAndView("index.html");  // Serve the welcome page
    }

    @GetMapping("/signup") 
    public String signup() {
        // Replace hardcoded IP with the Kubernetes service name for user-service
        return "redirect:http://user-service:8082/users/signup";  // Redirect to user-service signup page
    }

    @GetMapping("/login")
    public String login() {
        // Replace hardcoded IP with the Kubernetes service name for auth-service
        return "redirect:http://auth-service:8083/auth/login";  // Redirect to auth-service login page
    }
}