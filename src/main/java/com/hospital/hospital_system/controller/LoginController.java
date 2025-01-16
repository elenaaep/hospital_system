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
import org.springframework.web.context.request.WebRequest;

import java.util.Optional;

@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public String showLoginForm(Model model, WebRequest webRequest) {
        // Verifică dacă există un mesaj de succes în sesiune
        String successMessage = (String) webRequest.getAttribute("successMessage", WebRequest.SCOPE_SESSION);
        if (successMessage != null) {
            model.addAttribute("successMessage", successMessage); // Adaugă mesajul în model
            webRequest.removeAttribute("successMessage", WebRequest.SCOPE_SESSION); // Șterge mesajul din sesiune
        }
        model.addAttribute("error", false);
        model.addAttribute("message", "");
        return "login"; // numele fișierului HTML pentru login
    }

    @PostMapping("/login")
    public String handleLogin(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            Model model) {

        System.out.println("Username: " + username);
        System.out.println("Password: " + password);

        Optional<User> optionalUser = userRepository.findByUsername(username);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            System.out.println("Entered Password: " + password);
            System.out.println("Stored Hash: " + user.getParola());
            if (passwordEncoder.matches(password, user.getParola())) {
                System.out.println("Parola introdusă este corectă!");
                model.addAttribute("message", "Login successful!");
                return "redirect:/success";
            } else {
                System.out.println("Parola introdusă este greșită!");
                model.addAttribute("error", true);
                model.addAttribute("message", "Invalid username or password");
            }
        } else {
            System.out.println("User-ul nu există!");
            model.addAttribute("error", true);
            model.addAttribute("message", "Invalid username or password");
        }

        return "redirect:/login";
    }
}
