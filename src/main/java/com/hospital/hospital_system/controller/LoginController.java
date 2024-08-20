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

import java.util.Optional;

@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("error", false);
        model.addAttribute("message", "");
        return "login"; // numele fișierului HTML Thymeleaf
    }


//    @PostMapping("/login")
//    public String login(@RequestParam String uname, @RequestParam String password, Model model) {
//        System.out.println("Login attempt with username: " + uname); // Add debug output
//        Optional<User> optionalUser = userRepository.findByUname(uname);
//
//        if (optionalUser.isPresent()) {
//            User user = optionalUser.get();
//
//            boolean passwordMatch = passwordEncoder.matches(password, user.getParola());
//
//            System.out.println("User found: " + user);
//            System.out.println("Password check: " + passwordMatch);
//
//            if (passwordMatch) {
//                model.addAttribute("message", "Login successful!");
//                return "redirect:/doctor";
//            }
//        }
//
//        model.addAttribute("error", true);
//        model.addAttribute("message", "Invalid username or password");
//        return "login";
//    }


    @PostMapping("/login")
    public String handleLogin(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            Model model) {

        // Printăm username-ul și parola primite din form
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);

        // Verificăm dacă username-ul există în baza de date
        Optional<User> optionalUser = userRepository.findByUname(username);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();

            // Verificăm dacă parola introdusă corespunde cu cea encodată din baza de date
            if (passwordEncoder.matches(password, user.getParola())) {
                System.out.println("Parola introdusă este corectă!");
            } else {
                System.out.println("Parola introdusă este greșită!");
            }
        } else {
            System.out.println("User-ul nu există!");
        }

        return "redirect:/login"; // redirecționăm din nou către pagina de login
    }
}


