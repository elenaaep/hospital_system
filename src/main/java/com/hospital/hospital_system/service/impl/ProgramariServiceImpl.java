package com.hospital.hospital_system.service.impl;

import com.hospital.hospital_system.dto.ProgramariDto;
import com.hospital.hospital_system.models.Programari;
import com.hospital.hospital_system.repository.ProgramariRepository;
import com.hospital.hospital_system.service.ProgramariService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProgramariServiceImpl implements ProgramariService {
    private ProgramariRepository programariRepository;

    @Autowired
    public ProgramariServiceImpl(ProgramariRepository programariRepository) {
        this.programariRepository = programariRepository;
    }

    @Override
    public List<ProgramariDto> findAllProgramari() {
       List<Programari> programari=programariRepository.findAll();
       return programari.stream()
               .map(programari1 -> mapToProgramari(programari1))
               .collect(Collectors.toList());
    }

    private ProgramariDto mapToProgramari(Programari programari1)
    {
        ProgramariDto programariDto=ProgramariDto.builder()
                .idProgramare(programari1.getIdProgramare())
                .idPacient(programari1.getIdPacient())
                .idDoc(programari1.getIdDoc())
                .dataProgramare(programari1.getDataProgramare())
                .ora(programari1.getOra())
                .motiv(programari1.getMotiv())
                .build();
        return programariDto;
    }
}
