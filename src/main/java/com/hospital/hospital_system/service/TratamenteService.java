package com.hospital.hospital_system.service;

import com.hospital.hospital_system.dto.TratamenteDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TratamenteService {
    List<TratamenteDto> findAllTratamentes();
}
