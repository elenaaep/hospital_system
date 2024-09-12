package com.hospital.hospital_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
public class StatisticsController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/statistics")
    public String getStatistics(Model model) {
        Map<String, Long> statistics = new HashMap<>();

        try {
            long totalDoctors = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM doctor", Long.class);
            statistics.put("totalDoctors", totalDoctors);

            long totalNurses = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM asistent", Long.class);
            statistics.put("totalNurses", totalNurses);

            long totalPatients = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM pacient", Long.class);
            statistics.put("totalPatients", totalPatients);

            long totalAppointments = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM programari", Long.class);
            statistics.put("totalAppointments", totalAppointments);

            model.addAttribute("statistics", statistics);
        } catch (Exception e) {
            e.printStackTrace();
            // Handle error or log it as needed
            model.addAttribute("error", "An error occurred while retrieving statistics.");
        }

        return "statistics"; // Numele fișierului Thymeleaf (e.g., statistics.html)
    }
}
