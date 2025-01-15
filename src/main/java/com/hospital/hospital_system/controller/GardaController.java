package com.hospital.hospital_system.controller;

import com.hospital.hospital_system.dto.GardaDto;
import com.hospital.hospital_system.models.Garda;
import com.hospital.hospital_system.service.GardaService; // Adaugă importul pentru serviciu
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class GardaController {

    @Autowired
    private GardaService gardaService; // Injectează serviciul GardaService

    @GetMapping("/garda")
    public String showGardaList(Model model) {
        List<GardaDto> gardaList = gardaService.findAllGarda();  // Obține lista de gărzi
        System.out.println(gardaList);  // Verifică dacă lista conține date corecte
        model.addAttribute("gardaList", gardaList);
        return "garda";  // Numele fișierului garda.html
    }

    // Adăugare gardă
    @PostMapping("/garda/add")
    public String addGarda(Garda garda) {
        gardaService.addGarda(garda); // Folosește serviciul pentru adăugarea gărzii
        return "redirect:/garda"; // După adăugarea gărzii, se face redirect la pagina principală
    }

    // Editare gardă
    @PostMapping("/garda/edit")
    public String editGarda(Garda garda) {
        gardaService.editGarda(garda); // Folosește serviciul pentru editarea gărzii
        return "redirect:/garda"; // După editarea gărzii, se face redirect la pagina principală
    }

    // Ștergere gardă
    @PostMapping("/garda/delete")
    public String deleteGarda(int id_garda) {
        gardaService.deleteGarda(id_garda); // Folosește serviciul pentru ștergerea gărzii
        return "redirect:/garda"; // După ștergerea gărzii, se face redirect la pagina principală
    }
}
