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
        // Redirect to user-service signup page
        return "redirect:http://user-service:80/users/signup";  
    }

    @GetMapping("/login")
    public String login() {
        // Redirect to auth-service login page
        return "redirect:http://auth-service:80/auth/login";  
    }
}
