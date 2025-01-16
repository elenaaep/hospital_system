package com.hospital.hospital_system.controller;

import com.hospital.hospital_system.models.Pacienti;
import com.hospital.hospital_system.models.User;
import com.hospital.hospital_system.repository.PacientiRepository;
import com.hospital.hospital_system.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;

@Controller
public class RegistrationController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private PacientiRepository pacientiRepository;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("error", false);
        model.addAttribute("message", "");
        return "register"; // numele fișierului HTML Thymeleaf pentru înregistrare
    }

    @PostMapping("/register")
    public String handleRegistration(
            @RequestParam("nume") String nume,
            @RequestParam("prenume") String prenume,
            @RequestParam("cnp") String cnp,
            @RequestParam("data_nasterii") String dataNasterii,
            @RequestParam("gen") String gen,
            @RequestParam("varsta") Integer varsta,
            @RequestParam("adresa") String adresa,
            @RequestParam("tel") String telefon,
            @RequestParam("email") String email,
            @RequestParam("grupa_sange") String grupaSange,
            @RequestParam("rh") String rh,
            Model model) {

        // Creăm un nou pacient cu datele primite din formular
        Pacienti pacient = new Pacienti();
        pacient.setNume(nume);
        pacient.setPrenume(prenume);
        pacient.setCnp(cnp);
        pacient.setDataNasterii(Date.valueOf(dataNasterii));
        pacient.setGen(gen);
        pacient.setVarsta(varsta);
        pacient.setAdresa(adresa);
        pacient.setTel(Integer.parseInt(telefon));
        pacient.setEmail(email);
        pacient.setGrupaSange(grupaSange);
        pacient.setRh(rh);

        // Salvăm pacientul în baza de date
        pacientiRepository.save(pacient);

        // Setăm mesajul de succes în sesiune
        model.addAttribute("successMessage", "Contul a fost creat cu succes! Te poți autentifica acum.");

        // Redirecționăm către pagina de login
        return "redirect:/login"; // Redirecționează către pagina de login
    }
}
