package com.hospital.hospital_system.controller;

import com.hospital.hospital_system.models.User;
import com.hospital.hospital_system.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Controller
public class HomeController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        // Obține numele utilizatorului autentificat
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String loggedUsername = authentication.getName();

        // Caută detalii suplimentare în baza de date
        Optional<User> optionalUser = userRepository.findByUsername(loggedUsername);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            System.out.println("Utilizator găsit: " + user.getUsername()); // Debugging
            model.addAttribute("fullName", user.getUsername());
        } else {
            System.out.println("Utilizatorul nu a fost găsit."); // Debugging
            model.addAttribute("fullName", "Utilizator necunoscut");
        }

        // Returnează view-ul Thymeleaf cu numele 'dashboard'
        return "dashboard";
    }


}

