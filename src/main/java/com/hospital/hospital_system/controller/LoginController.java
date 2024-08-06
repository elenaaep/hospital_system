package com.hospital.hospital_system.controller;

import com.hospital.hospital_system.models.User;
import com.hospital.hospital_system.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("error", false);
        model.addAttribute("message", "");
        return "login"; // numele fișierului HTML Thymeleaf
    }

    @PostMapping("/login")
    public String login(@RequestParam String uname, @RequestParam String password, Model model) {
        Optional<User> optionalUser = userRepository.findByUname(uname);
        if (optionalUser.isPresent() && optionalUser.get().getParola().equals(password)) {
            model.addAttribute("message", "Login successful!");
            return "doctor"; //  pagina dupa autentificare
        } else {
            model.addAttribute("error", true);
            model.addAttribute("message", "Invalid username or password");
            return "login"; // ramai pe pagina de login cu mesaj de eroare
        }
    }
}
