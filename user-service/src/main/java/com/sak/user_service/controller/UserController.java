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
    public String signupUser(@ModelAttribute User user, Model model) {
        try {
            userRepository.save(user);  // Save the user to the database
            model.addAttribute("success", "User signed up successfully!"); // Success message
            return "redirect:/users/login";  // Redirect to the login page after saving
        } catch (Exception e) {
            model.addAttribute("error", "Signup failed: " + e.getMessage()); // Error message
            return "signup";  // Stay on the signup page if there's an error
        }
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("user", new User());
        return "redirect:http://auth-service:80/auth/login";  // Redirect to auth-service login
    }

    @GetMapping("/")
    public String home() {
        return "redirect:http://welcome-service:80";  // Redirect to welcome-service home page
    }
}
