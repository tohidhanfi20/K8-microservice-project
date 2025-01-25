package com.sak.user_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sak.user_service.repository.UserRepository;
import com.sak.user_service.entity.User;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/signup") 
    public String signup(Model model) {
        model.addAttribute("user", new User());
        return "signup.html";  // Serve the signup page
    }

    @PostMapping("/signup")
    public String signupUser(@ModelAttribute User user) {
        userRepository.save(user);  // Save the user to the database
        return "redirect:/users/signup";  // Redirect back to the signup page after saving
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("user", new User());
        // Replace hardcoded IP with the Kubernetes service name for auth-service
        return "redirect:http://auth-service:8083/auth/login";  // Redirect to auth-service login
    }

    @GetMapping("/")
    public String home() {
        // Replace hardcoded IP with the Kubernetes service name for welcome-service
        return "redirect:http://welcome-service:8081";  // Redirect to welcome-service home page
    }
}