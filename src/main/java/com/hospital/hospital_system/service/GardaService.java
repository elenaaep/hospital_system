package com.hospital.hospital_system.service;

import com.hospital.hospital_system.dto.GardaDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GardaService {
    List<GardaDto> findAllGarda();
}
