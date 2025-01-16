package com.hospital.hospital_system.controller;

import com.hospital.hospital_system.dto.MesajDTO;
import com.hospital.hospital_system.models.Mesaj;
import com.hospital.hospital_system.service.MessageService;
import com.hospital.hospital_system.service.PacientiService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;


@Controller
@RequestMapping("/mesaje")
public class MesajController {

    private static final Logger logger = LoggerFactory.getLogger(MesajController.class);
    private final MessageService messageService;
    private final PacientiService pacientiService;

    public MesajController(MessageService messageService, PacientiService pacientiService) {
        this.messageService = messageService;
        this.pacientiService = pacientiService;
    }

    // Show the form to send a message
    @GetMapping("/formular")
    public String showMessageForm(Model model) {
        model.addAttribute("mesajDTO", new MesajDTO());
        model.addAttribute("pacienti", pacientiService.findAllPacienti());
        logger.info("Accessing /mesaje/formular endpoint to display form");
        return "formular_mesaj";  // Thymeleaf template to render the form
    }

    // Handle form submission to send the message
    @PostMapping
    public String sendMessage(@ModelAttribute MesajDTO mesajDTO, Model model) {
        try {
            messageService.sendMessage(mesajDTO);
            logger.info("Message sent successfully from patient {} to doctor {}", mesajDTO.getPacientId(), mesajDTO.getDoctorId());
            return "redirect:/mesaje/formular";  // Redirect to the form page
        } catch (Exception e) {
            logger.error("Error occurred while sending message", e);
            model.addAttribute("error", "Failed to send message");
            return "error";  // Show an error page if the message fails to send
        }
    }

    // Retrieve all messages
    @GetMapping
    public ResponseEntity<List<Mesaj>> getAllMessages() {
        logger.info("Accessing /mesaje endpoint to retrieve messages");
        List<Mesaj> mesaje = messageService.getAllMessages();
        return ResponseEntity.ok(mesaje);
    }
}

