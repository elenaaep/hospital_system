package com.hospital.hospital_system.service.impl;

import com.hospital.hospital_system.dto.AsistentDto;
import com.hospital.hospital_system.models.Asistent;
import com.hospital.hospital_system.repository.AsistentRepository;
import com.hospital.hospital_system.service.AsistentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AsistentServiceImpl implements AsistentService {
    private AsistentRepository asistentRepository;

    @Autowired
    public AsistentServiceImpl(AsistentRepository asistentRepository) {
        this.asistentRepository = asistentRepository;
    }

    @Override
    public List<AsistentDto> findAllAsistent(){
        List<Asistent> asistent=asistentRepository.findAll();
        return asistent.stream()
                .map(asistent1 -> mapToAsistentDto(asistent1))
                .collect(Collectors.toList());
    }

    private AsistentDto mapToAsistentDto(Asistent asistent1){
        AsistentDto asistentDto=AsistentDto.builder()
                .idAsistent(asistent1.getIdAsistent())
                .nume(asistent1.getNume())
                .prenume(asistent1.getPrenume())
                .cnp(asistent1.getCnp())
                .dataNasterii(asistent1.getDataNasterii())
                .gen(asistent1.getGen())
                .tel(asistent1.getTel())
                .email(asistent1.getEmail())
                .tipAsistent(asistent1.getTipAsistent())
                .etaj(asistent1.getEtaj())
                .build();
        return asistentDto;

    }
}
