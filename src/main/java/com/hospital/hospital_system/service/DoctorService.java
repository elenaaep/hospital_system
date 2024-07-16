package com.hospital.hospital_system.service;

import com.hospital.hospital_system.dto.DoctorDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DoctorService {
    List<DoctorDto> findAllDoctor();
}
