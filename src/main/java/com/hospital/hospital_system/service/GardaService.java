package com.hospital.hospital_system.service;

import com.hospital.hospital_system.dto.GardaDto;
import com.hospital.hospital_system.dto.PacientiDto;
import com.hospital.hospital_system.models.Garda;
import com.hospital.hospital_system.repository.GardaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public interface GardaService {
    List<GardaDto> findAllGarda();

    void addGarda(GardaDto garda);

    void deleteGarda(int id_garda);

    GardaDto findById(int id);

    void updateGarda(int id, GardaDto gardaDto);

    List<GardaDto> searchGarda(String searchTerm, Integer idDoc, Integer idAsistent, String persTip);

    List<GardaDto> searchGarda(String searchTerm, int idDoc, int idAsistent, String persTip);

    void saveGarda(Garda garda);

    List<Garda> getAllGarde();

    List<Garda> getGardeByDateRange(LocalDate startDate, LocalDate endDate);
}
