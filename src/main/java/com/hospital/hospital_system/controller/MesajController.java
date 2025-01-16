package com.hospital.hospital_system.controller;

import com.hospital.hospital_system.dto.MesajDTO;
import com.hospital.hospital_system.models.Mesaj;
import com.hospital.hospital_system.service.MessageService;
import com.hospital.hospital_system.service.PacientiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

import java.util.List;

@Controller
@RequestMapping("/mesaje")
public class MesajController {

    @Autowired
    private MessageService mesajService;
    private PacientiService pacientiService;

    // Obținerea tuturor mesajelor
    @GetMapping
    public ResponseEntity<List<Mesaj>> getAllMessages() {
        List<Mesaj> mesaje = mesajService.getAllMessages();
        return ResponseEntity.ok(mesaje);
    }

    // Obținerea unui mesaj după ID
    @GetMapping("/{id}")
    public ResponseEntity<Mesaj> getMessageById(@PathVariable Long id) {
        Mesaj mesaj = mesajService.getMessageById(id);
        return ResponseEntity.ok(mesaj);
    }

    private final MessageService messageService;

    @Autowired
    public MesajController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/mesaje/formular")
    public String showMessageForm(Model model) {
        model.addAttribute("mesajDTO", new MesajDTO());

        model.addAttribute("pacienti", pacientiService.findAllPacienti());  // Trimite lista pacienților
        return "contact";  // Formularul va fi renderizat folosind Thymeleaf
    }

    // Endpoint pentru trimiterea mesajului
    @PostMapping("/mesaje")
    public String sendMessage(@ModelAttribute MesajDTO mesajDTO) {
        messageService.sendMessage(mesajDTO); // Apelează logica de trimitere a mesajului
        return "redirect:/mesaje/contact"; // După trimitere, redirecționează înapoi la formular
    }
}
