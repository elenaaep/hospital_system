package com.hospital.hospital_system.controller;

import com.hospital.hospital_system.dto.DoctorDto;
import com.hospital.hospital_system.service.DoctorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@Controller
public class DoctorController {

    private static final Logger logger = LoggerFactory.getLogger(DoctorController.class);
    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping("/doctor")
    public String getAllDoctors(Model model) {
        try {
            List<DoctorDto> doctors = doctorService.findAllDoctor();
            model.addAttribute("doctor", doctors);
            logger.info("Accessing /doctor endpoint: Retrieved {} doctors", doctors.size());
            return "doctor";
        } catch (Exception e) {
            logger.error("Error occurred while retrieving doctors", e);
            model.addAttribute("error", "An error occurred while retrieving the list of doctors.");
            return "error";
        }
    }
}
