package com.hospital.hospital_system.controller;

import com.hospital.hospital_system.models.Pacienti;
import com.hospital.hospital_system.repository.PacientiRepository;
import com.hospital.hospital_system.service.PacientiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/pacienti")
public class PacientController {

    private final PacientiService pacientiService;

    public PacientController(PacientiService pacientiService) {
        this.pacientiService = pacientiService;
    }

    @Autowired
    private PacientiRepository pacientRepository;

    @GetMapping
    public List<Pacienti> getAllPacienti(
            @RequestParam(value = "search", required = false) String search,
            @RequestParam(value = "grupaSange", required = false) String grupaSange,
            @RequestParam(value = "rh", required = false) String rh) {

        if (search != null && !search.isEmpty()) {
            // Filtrare pe baza unui câmp specific, exemplu:
         //   return pacientRepository.findByNumeContainingIgnoreCaseOrPrenumeContainingIgnoreCase(search, search);
        }

//        // Filtrare după grupă de sânge și Rh
//        if (grupaSange != null && rh != null) {
//            return pacientRepository.findByGrupaSangeAndRh(grupaSange, rh);
//        } else if (grupaSange != null) {
//            return pacientRepository.findByGrupaSange(grupaSange);
//        } else if (rh != null) {
//            return pacientRepository.findByRh(rh);
//        }

        return pacientRepository.findAll();
    }
}
