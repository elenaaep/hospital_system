package com.hospital.hospital_system.service;

import com.hospital.hospital_system.dto.GardaDto;
import com.hospital.hospital_system.models.Garda;
import com.hospital.hospital_system.repository.GardaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GardaService {
    List<GardaDto> findAllGarda();

    void addGarda(Garda garda);

    void editGarda(Garda garda);

    void deleteGarda(int id_garda);
}
