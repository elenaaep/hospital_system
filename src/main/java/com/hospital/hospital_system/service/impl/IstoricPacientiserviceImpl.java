package com.hospital.hospital_system.service.impl;

import com.hospital.hospital_system.dto.IstoricPacientiDto;
import com.hospital.hospital_system.models.IstoricPacienti;
import com.hospital.hospital_system.repository.IstoricPacientiRepository;
import com.hospital.hospital_system.service.IstoricPacientiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IstoricPacientiserviceImpl implements IstoricPacientiService {
    private IstoricPacientiRepository istoricPacientiRepository;

    @Autowired
    public IstoricPacientiserviceImpl(IstoricPacientiRepository istoricPacientiRepository) {
        this.istoricPacientiRepository = istoricPacientiRepository;
    }

    @Override
    public List<IstoricPacientiDto> findAllIstoricPacienti() {
        List<IstoricPacienti> istoricPacienti=istoricPacientiRepository.findAll();
        return istoricPacienti.stream()
                .map(istoricPacienti1 -> mapToIstoricPacienti(istoricPacienti1))
                .collect(Collectors.toList());
    }

    private IstoricPacientiDto mapToIstoricPacienti(IstoricPacienti istoricPacienti1)
    {
       IstoricPacientiDto istoricPacientiDto=IstoricPacientiDto.builder()
               .idIst(istoricPacienti1.getIdIst())
               .idPacient(istoricPacienti1.getIdPacient())
               .idProgramare(istoricPacienti1.getIdProgramare())
               .idInternare(istoricPacienti1.getIdInternare())
               .idDoc(istoricPacienti1.getIdDoc())
               .idAnalize(istoricPacienti1.getIdAnalize())
               .idTratament(istoricPacienti1.getIdTratament())
               .observatii(istoricPacienti1.getObservatii())
               .build();
       return istoricPacientiDto;
    }
}
