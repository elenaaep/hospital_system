package com.hospital.hospital_system.controller;

import com.hospital.hospital_system.models.User;
import com.hospital.hospital_system.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegistrationController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("error", false);
        model.addAttribute("message", "");
        return "register"; // numele fișierului HTML Thymeleaf pentru înregistrare
    }

    @PostMapping("/register")
    public String handleRegistration(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            @RequestParam("name") String name,
            @RequestParam("role") String role,
            Model model) {

        // Verificăm dacă username-ul este deja folosit
        if (userRepository.findByUname(username).isPresent()) {
            model.addAttribute("error", true);
            model.addAttribute("message", "Username already exists");
            return "register";
        }


        String encodedPassword = passwordEncoder.encode(password);


        User newUser = new User();
        newUser.setUname(username);
        newUser.setParola(encodedPassword);
        newUser.setUtip(role);


        userRepository.save(newUser);

        return "redirect:/login";
    }
}
