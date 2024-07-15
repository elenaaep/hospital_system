package com.hospital.hospital_system.service;

import com.hospital.hospital_system.dto.AnalizeMedicaleDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AnalizeMedicaleService {
     List<AnalizeMedicaleDto> findAllAnalizeMedicale() ;
}
