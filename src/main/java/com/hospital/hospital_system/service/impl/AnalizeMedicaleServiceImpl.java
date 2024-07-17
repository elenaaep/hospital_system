package com.hospital.hospital_system.service.impl;

import com.hospital.hospital_system.dto.AnalizeMedicaleDto;
import com.hospital.hospital_system.models.AnalizeMedicale;
import com.hospital.hospital_system.repository.AnalizeMedicaleRepository;
import com.hospital.hospital_system.service.AnalizeMedicaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnalizeMedicaleServiceImpl implements AnalizeMedicaleService {

    private AnalizeMedicaleRepository analizeMedicaleRepository;

   @Autowired
    public AnalizeMedicaleServiceImpl(AnalizeMedicaleRepository analizeMedicaleRepository) {
        this.analizeMedicaleRepository = analizeMedicaleRepository;
    }

    @Override
    public List<AnalizeMedicaleDto> findAllAnalizeMedicale() {
        List<AnalizeMedicale> analizeMedicale = analizeMedicaleRepository.findAll();
        return analizeMedicale.stream()
                .map(analizeMedicale1 -> mapToAnalizeMedicaleDto(analizeMedicale1))
                .collect(Collectors.toList());
    }


    private AnalizeMedicaleDto mapToAnalizeMedicaleDto(AnalizeMedicale analizeMedicale1){
        AnalizeMedicaleDto analizeMedicaleDto=AnalizeMedicaleDto.builder()
                .idAnalize(analizeMedicale1.getIdAnalize())
                .idPacient(analizeMedicale1.getIdPacient())
                .idDoc(analizeMedicale1.getIdDoc())
                .tipAnaliza((analizeMedicale1.getTipAnaliza()))
                .dataEfectuare(analizeMedicale1.getDataEfectuare())
                .rezultate(analizeMedicale1.getRezultate())
                .valoriNormale(analizeMedicale1.getValoriNormale())
                .executantAnalize(analizeMedicale1.getExecutantAnalize())
                .observatii(analizeMedicale1.getObservatii())
                .build();
        return analizeMedicaleDto;
    }
}
