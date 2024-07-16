package com.hospital.hospital_system.service;

import com.hospital.hospital_system.dto.ProgramariDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProgramariService {
    List<ProgramariDto> findAllProgramari();
}
