package com.hospital.hospital_system.service;

import com.hospital.hospital_system.dto.AsistentDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AsistentService {
    List<AsistentDto> findAllAsistent() ;
}
