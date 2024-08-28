package com.hospital.hospital_system.controller;

import com.hospital.hospital_system.dto.PacientiDto;
import com.hospital.hospital_system.service.PacientiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.List;

@Controller
public class PacientiController {

    private static final Logger logger = LoggerFactory.getLogger(PacientiController.class);
    private final PacientiService pacientiService;

    @Autowired
    public PacientiController(PacientiService pacientiService) {
        this.pacientiService = pacientiService;
    }

    // Endpoint pentru a returna pagina HTML
    @GetMapping("/pacients")
    public String getPacientiPage(Model model) {
        try {
            List<PacientiDto> pacients = pacientiService.findAllPacienti();
            model.addAttribute("pacient", pacients);
            logger.info("Accessing /pacients endpoint: Retrieved {} pacienti", pacients.size());
            return "vizualizare_pacienti";
        } catch (Exception e) {
            logger.error("Error occurred while retrieving pacients", e);
            model.addAttribute("error", "An error occurred while retrieving the list of pacients.");
            return "error"; //
        }
    }

    // Endpoint pentru a obține lista de pacienți în format JSON
    @GetMapping("/list")
    @ResponseBody
    public List<PacientiDto> getAllPacienti() {
        return pacientiService.findAllPacienti();
    }
}
