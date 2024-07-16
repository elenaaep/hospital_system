package com.hospital.hospital_system.controller;

import com.hospital.hospital_system.dto.DoctorDto;
import com.hospital.hospital_system.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class DoctorController {

    private final DoctorService doctorService;

    @Autowired
    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping("http://localhost:8080/doctor")
    public String doctor(Model model) {
        List<DoctorDto> doctor = doctorService.findAllDoctor();
        model.addAttribute("doctor", doctor);
        System.out.println("Accessing /doctor endpoint");
        return "doctor";
    }

}
