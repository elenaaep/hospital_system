package com.hospital.hospital_system.service.impl;

import com.hospital.hospital_system.dto.TratamenteDto;
import com.hospital.hospital_system.models.Tratamente;
import com.hospital.hospital_system.repository.TratamenteRepository;
import com.hospital.hospital_system.service.TratamenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TratamenteServiceImpl implements TratamenteService {
    private TratamenteRepository tratamenteRepository;

    @Autowired
    public TratamenteServiceImpl(TratamenteRepository tratamenteRepository) {
        this.tratamenteRepository = tratamenteRepository;
    }

    @Override
    public List<TratamenteDto> findAllTratamentes() {
        List<Tratamente> tratamente = tratamenteRepository.findAll();
        return tratamente.stream()
                .map(tratamente1 -> mapToTratamente(tratamente1))
                .collect(Collectors.toList());
    }

    private TratamenteDto mapToTratamente(Tratamente tratamente1) {
        TratamenteDto tratamenteDto=TratamenteDto.builder()
                .idTratament(tratamente1.getIdTratament())
                .idPacient(tratamente1.getIdPacient())
                .denumireTratament(tratamente1.getDenumireTratament())
                .doza(tratamente1.getDoza())
                .dataInceput(tratamente1.getDataInceput())
                .ora(tratamente1.getOra())
                .dataSfarsit(tratamente1.getDataSfarsit())
                .observatii(tratamente1.getObservatii())
                .build();
        return tratamenteDto;
    }
}
