package com.hospital.hospital_system.service;

import com.hospital.hospital_system.dto.InternariDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface InternariService {
    List<InternariDto> findAllInternari();
}
