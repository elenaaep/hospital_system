package com.hospital.hospital_system.service;

import com.hospital.hospital_system.dto.PacientiDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PacientiService {
    List<PacientiDto> findAllPacienti();
    void addPacient(PacientiDto pacient);
    void updatePacient(int id, PacientiDto pacientDto); // Adaugă această metodă
    void deletePacient(int id);

    PacientiDto findById(int id);

    List<PacientiDto> searchPacienti(String searchTerm);

    // Căutare pacienți după criterii multiple (searchTerm, gen, Rh, grupa de sânge)
    List<PacientiDto> searchPacienti(String searchTerm, String gen, String rh, String grupaSange);
}
