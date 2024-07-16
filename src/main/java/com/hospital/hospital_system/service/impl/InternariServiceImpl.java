package com.hospital.hospital_system.service.impl;

import com.hospital.hospital_system.dto.InternariDto;
import com.hospital.hospital_system.models.Internari;
import com.hospital.hospital_system.repository.InternariRepository;
import com.hospital.hospital_system.service.InternariService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class InternariServiceImpl implements InternariService {
    private InternariRepository internariRepository;

    @Autowired
    public InternariServiceImpl(InternariRepository internariRepository) {
        this.internariRepository = internariRepository;
    }

    @Override
    public List<InternariDto> findAllInternari() {
        List<Internari> internari=internariRepository.findAll();
        return internari.stream()
                .map(internari1 -> mapToInternari(internari1))
                .collect(Collectors.toList());
    }

    private InternariDto mapToInternari(Internari internari1){
        InternariDto internariDto= InternariDto.builder()
                .idInternare(internari1.getIdInternare())
                .idPacient(internari1.getIdPacient())
                .data(internari1.getData())
                .motiv(internari1.getMotiv())
                .greutate(internari1.getGreutate())
                .puls(internari1.getPuls())
                .tensiune(internari1.getTensiune())
                .bolnavCronic(internari1.isBolnavCronic())
                .alergii(internari1.getAlergii())
                .diagnostic(internari1.getDiagnostic())
                .observatii(internari1.getObservatii())
                .build();
        return internariDto;
    }
}
