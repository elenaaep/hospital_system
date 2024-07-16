package com.hospital.hospital_system.service;

import com.hospital.hospital_system.dto.PacientiDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PacientiService {
    List<PacientiDto> findAllPacienti();
}
