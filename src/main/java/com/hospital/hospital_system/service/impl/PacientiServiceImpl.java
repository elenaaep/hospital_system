package com.hospital.hospital_system.service.impl;

import com.hospital.hospital_system.dto.PacientiDto;
import com.hospital.hospital_system.models.Pacienti;
import com.hospital.hospital_system.repository.PacientiRepository;
import com.hospital.hospital_system.service.PacientiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PacientiServiceImpl implements PacientiService {

    private PacientiRepository pacientiRepository;

    @Autowired
    public PacientiServiceImpl(PacientiRepository pacientiRepository) {
        this.pacientiRepository = pacientiRepository;
    }

    @Override
    public List<PacientiDto> findAllPacienti() {
        List<Pacienti> pacienti=pacientiRepository.findAll();
        return pacienti.stream()
                .map(pacienti1 -> mapToPacienti(pacienti1))
                .collect(Collectors.toList());
    }

    private PacientiDto mapToPacienti(Pacienti pacienti1){
        PacientiDto pacientiDto=PacientiDto.builder()
                .idPacient(pacienti1.getIdPacient())
                .nume(pacienti1.getNume())
                .prenume(pacienti1.getPrenume())
                .cnp(pacienti1.getCnp())
                .dataNasterii(pacienti1.getDataNasterii())
                .gen(pacienti1.getGen())
                .varsta(pacienti1.getVarsta())
                .adresa(pacienti1.getAdresa())
                .tel(pacienti1.getTel())
                .email(pacienti1.getEmail())
                .grupaSange(pacienti1.getGrupaSange())
                .rh(pacienti1.getRh())
                .build();
        return pacientiDto;
    }
}
