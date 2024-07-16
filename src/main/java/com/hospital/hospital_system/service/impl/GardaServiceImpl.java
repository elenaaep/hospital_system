package com.hospital.hospital_system.service.impl;

import com.hospital.hospital_system.dto.GardaDto;
import com.hospital.hospital_system.models.Garda;
import com.hospital.hospital_system.repository.GardaRepository;
import com.hospital.hospital_system.service.GardaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GardaServiceImpl implements GardaService {

    private GardaRepository gardaRepository;

    @Autowired
    public GardaServiceImpl(GardaRepository gardaRepository) {
        this.gardaRepository = gardaRepository;
    }

    @Override
    public List<GardaDto> findAllGarda() {
        List<Garda> garda=gardaRepository.findAll();
        return garda.stream()
                .map(garda1 -> mapToGarda(garda1))
                .collect(Collectors.toList());
    }

    private GardaDto mapToGarda(Garda garda1){
        GardaDto gardaDto=GardaDto.builder()
                .idGarda(garda1.getIdGarda())
                .idDoc(garda1.getIdDoc())
                .idAsistent(garda1.getIdAsistent())
                .persTip(garda1.getPersTip())
                .dataInceput(garda1.getDataInceput())
                .dataSfarsit(garda1.getDataSfarsit())
                .nrPacientiIngrijiti(garda1.getNrPacientiIngrijiti())
                .consumabileFolosite(garda1.getConsumabileFolosite())
                .build();
        return gardaDto;
    }
}
