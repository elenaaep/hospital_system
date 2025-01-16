package com.hospital.hospital_system.controller;

import com.hospital.hospital_system.dto.PacientiDto;

import com.hospital.hospital_system.models.Pacienti;
import com.hospital.hospital_system.repository.PacientiRepository;
import com.hospital.hospital_system.service.DocumentException;
import com.hospital.hospital_system.service.PacientiService;
import com.hospital.hospital_system.service.PdfExportService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

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


    @GetMapping("/pacients")
    public String getPacientiPage(@RequestParam(value = "search", required = false) String searchTerm,
                                  @RequestParam(value = "gen", required = false) String gen,
                                  @RequestParam(value = "rh", required = false) String rh,
                                  @RequestParam(value = "grupaSange", required = false) String grupaSange,
                                  Model model) {
        try {
            List<PacientiDto> pacients;
            if (searchTerm != null && !searchTerm.isEmpty() || gen != null || rh != null || grupaSange != null) {
                pacients = pacientiService.searchPacienti(searchTerm, gen, rh, grupaSange); // Trimite filtrele către service
            } else {
                pacients = pacientiService.findAllPacienti();
            }
            model.addAttribute("pacienti", pacients);
            model.addAttribute("searchTerm", searchTerm);
            model.addAttribute("gen", gen);
            model.addAttribute("rh", rh);
            model.addAttribute("grupaSange", grupaSange);
            logger.info("Accessing /pacients endpoint: Retrieved {} pacienti", pacients.size());
            return "vizualizare_pacienti";
        } catch (Exception e) {
            logger.error("Error occurred while retrieving pacients", e);
            model.addAttribute("error", "An error occurred while retrieving the list of pacients.");
            return "error";
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

    @Autowired
    private PdfExportService pdfExportService;

    @Autowired
    private PacientiRepository pacientRepository;


    @GetMapping("/exportPacienti")
    public ResponseEntity<byte[]> exportPacienti() throws IOException, DocumentException {
        logger.info("Export PDF requested"); // Log pentru debugging
        List<PacientiDto> pacienti = pacientiService.findAllPacienti();
        ByteArrayOutputStream pdfStream = pdfExportService.generatePacientTablePdf(pacienti);
        byte[] pdfBytes = pdfStream.toByteArray();
        logger.info("PDF generated successfully");

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=PacientiList.pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdfBytes);
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
