package com.hospital.hospital_system.service;

import com.hospital.hospital_system.dto.IstoricPacientiDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IstoricPacientiService {
    List<IstoricPacientiDto> findAllIstoricPacienti();
}
