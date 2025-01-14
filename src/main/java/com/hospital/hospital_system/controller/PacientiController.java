package com.hospital.hospital_system.controller;

import com.hospital.hospital_system.dto.PacientiDto;
import com.hospital.hospital_system.service.PacientiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@Controller
public class PacientiController {

    private static final Logger logger = LoggerFactory.getLogger(PacientiController.class);
    private final PacientiService pacientiService;

    @Autowired
    public PacientiController(PacientiService pacientiService) {
        this.pacientiService = pacientiService;
    }

    // Endpoint pentru a returna pagina HTML cu pacienți
    @GetMapping("/pacients")
    public String getPacientiPage(Model model) {
        try {
            List<PacientiDto> pacients = pacientiService.findAllPacienti();
            model.addAttribute("pacienti", pacients);  // Adăugăm lista de pacienți în model
            logger.info("Accessing /pacients endpoint: Retrieved {} pacienti", pacients.size());
            return "vizualizare_pacienti";  // Returnează pagina HTML
        } catch (Exception e) {
            logger.error("Error occurred while retrieving pacients", e);
            model.addAttribute("error", "An error occurred while retrieving the list of pacients.");
            return "error";  // În caz de eroare, arată pagina de eroare
        }
    }


    @GetMapping("/new")
    public String showAddPacientForm(Model model) {
        model.addAttribute("pacient", new PacientiDto());
        return "new-pacient";
    }

    @PostMapping("/add")
    public String addPacient(@ModelAttribute PacientiDto pacientDto) {
        pacientiService.addPacient(pacientDto); // Adaugă pacientul în serviciu (logica de salvare)
        return "redirect:/pacients"; // După adăugare, redirecționează către lista de pacienți
    }

    @GetMapping("/edit/{id}")
    public String showEditPacientForm(@PathVariable int id, Model model) {
        PacientiDto pacientDto = pacientiService.findById(id); // Asigură-te că metoda există
        model.addAttribute("pacient", pacientDto);
        return "edit-pacient";
    }

    @PostMapping("/pacienti/update/{id}")
    public String updatePacient(@PathVariable int id, @ModelAttribute PacientiDto pacientDto) {
        // Actualizează pacientul
        pacientiService.updatePacient(id, pacientDto);

        // Logică pentru actualizarea pacientului
        return "redirect:/pacients";
    }
    @GetMapping("/pacienti/delete/{id}")
    public String deletePacient(@PathVariable int id, Model model) {
        try {
            pacientiService.deletePacient(id);
            return "redirect:/pacients"; // Redirecționează către lista de pacienți
        } catch (Exception e) {
            model.addAttribute("error", "An error occurred while deleting the pacient.");
            return "error";
        }
    }



    // Endpoint pentru datele graficului Gen vs Vârstă
    @GetMapping("/api/chart/gen-varsta")
    @ResponseBody
    public Map<String, Object> getGenVarstaData() {
        List<PacientiDto> pacients = pacientiService.findAllPacienti();

        // Grupăm după gen și calculăm vârsta medie
        Map<String, Double> genVarsta = pacients.stream()
                .collect(Collectors.groupingBy(
                        PacientiDto::getGen,
                        Collectors.averagingDouble(PacientiDto::getVarsta)
                ));

        Map<String, Object> result = new HashMap<>();
        result.put("labels", genVarsta.keySet());
        result.put("data", genVarsta.values());
        return result;  // Returnează datele pentru grafic
    }

    // Endpoint pentru datele graficului Rh vs Grupa de Sânge
    @GetMapping("/api/chart/rh-grupa")
    @ResponseBody
    public Map<String, Object> getRhGrupaData() {
        List<PacientiDto> pacients = pacientiService.findAllPacienti();

        // Grupăm după combinația Rh + grupa de sânge și calculăm numărul de pacienți
        Map<String, Long> rhGrupa = pacients.stream()
                .collect(Collectors.groupingBy(
                        pacient -> pacient.getRh() + " - " + pacient.getGrupaSange(),
                        Collectors.counting()
                ));

        Map<String, Object> result = new HashMap<>();
        result.put("labels", rhGrupa.keySet());
        result.put("data", rhGrupa.values());
        return result;  // Returnează datele pentru grafic
    }
}
