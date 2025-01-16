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

    @Override
    public void addPacient(PacientiDto pacient) {
        Pacienti pacientEntity = mapToEntity(pacient);
        pacientiRepository.save(pacientEntity);
    }

    @Override
    public void updatePacient(int id, PacientiDto pacientDto) {
        // Găsește pacientul existent
        Pacienti pacient = pacientiRepository.findByIdPacient(id)
                .orElseThrow(() -> new RuntimeException("Pacientul nu a fost găsit!"));

        // Actualizează câmpurile
        pacient.setNume(pacientDto.getNume());
        pacient.setPrenume(pacientDto.getPrenume());
        pacient.setCnp(pacientDto.getCnp());
        pacient.setDataNasterii(pacientDto.getDataNasterii());
        pacient.setGen(pacientDto.getGen());
        pacient.setGrupaSange(pacientDto.getGrupaSange());
        pacient.setRh(pacientDto.getRh());

        // Salvează modificările
        pacientiRepository.save(pacient);
    }
    @Override
    public void deletePacient(int id) {
        Pacienti pacient = pacientiRepository.findByIdPacient(id)
                .orElseThrow(() -> new RuntimeException("Pacient not found"));
        pacientiRepository.delete(pacient);
    }

    private Pacienti mapToEntity(PacientiDto pacientiDto) {
        return Pacienti.builder()
                .idPacient(pacientiDto.getIdPacient())
                .nume(pacientiDto.getNume())
                .prenume(pacientiDto.getPrenume())
                .cnp(pacientiDto.getCnp())
                .dataNasterii(pacientiDto.getDataNasterii())
                .gen(pacientiDto.getGen())
                .varsta(pacientiDto.getVarsta())
                .adresa(pacientiDto.getAdresa())
                .tel(pacientiDto.getTel())
                .email(pacientiDto.getEmail())
                .grupaSange(pacientiDto.getGrupaSange())
                .rh(pacientiDto.getRh())
                .build();
    }

    public PacientiDto findById(int id) {
        // Exemplu simplificat
        Pacienti pacient = pacientiRepository.findById(id).orElseThrow(() -> new RuntimeException("Pacient not found"));
        return PacientiDto.builder()
                .idPacient(pacient.getIdPacient())
                .nume(pacient.getNume())
                .prenume(pacient.getPrenume())
                .cnp(pacient.getCnp())
                .dataNasterii(pacient.getDataNasterii())
                .gen(pacient.getGen())
                .varsta(pacient.getVarsta())
                .adresa(pacient.getAdresa())
                .tel(pacient.getTel())
                .email(pacient.getEmail())
                .grupaSange(pacient.getGrupaSange())
                .rh(pacient.getRh())
                .build();
    }

    @Override
    public List<PacientiDto> searchPacienti(String searchTerm) {
        return List.of();
    }

    // Căutare pacienți după criterii multiple (searchTerm, gen, Rh, grupa de sânge)
    @Override
    public List<PacientiDto> searchPacienti(String searchTerm, String gen, String rh, String grupaSange) {
        List<Pacienti> pacienti = pacientiRepository.findAll();  // Aici poți adapta în funcție de nevoi

        return pacienti.stream()
                .filter(pacient -> {
                    boolean matchesSearchTerm = (searchTerm == null || searchTerm.isEmpty()) ||
                            pacient.getNume().toLowerCase().contains(searchTerm.toLowerCase()) ||
                            pacient.getPrenume().toLowerCase().contains(searchTerm.toLowerCase()) ||
                            pacient.getCnp().contains(searchTerm) ||
                            pacient.getAdresa().toLowerCase().contains(searchTerm.toLowerCase()) ||
                            String.valueOf(pacient.getTel()).contains(searchTerm) ||
                            pacient.getEmail().toLowerCase().contains(searchTerm.toLowerCase()) ||
                            pacient.getGrupaSange().contains(searchTerm) ||
                            pacient.getRh().toLowerCase().contains(searchTerm.toLowerCase());

                    boolean matchesGen = (gen == null || gen.isEmpty() || pacient.getGen().equalsIgnoreCase(gen));
                    boolean matchesRh = (rh == null || rh.isEmpty() || pacient.getRh().equalsIgnoreCase(rh));
                    boolean matchesGrupaSange = (grupaSange == null || grupaSange.isEmpty() || pacient.getGrupaSange().equalsIgnoreCase(grupaSange));

                    return matchesSearchTerm && matchesGen && matchesRh && matchesGrupaSange;
                })
                .map(this::mapToPacientiDto)
                .collect(Collectors.toList());
    }



    private PacientiDto mapToPacientiDto(Pacienti pacient) {
        PacientiDto pacientDto = new PacientiDto();
        pacientDto.setIdPacient(pacient.getIdPacient());
        pacientDto.setNume(pacient.getNume());
        pacientDto.setPrenume(pacient.getPrenume());
        pacientDto.setCnp(pacient.getCnp());
        pacientDto.setAdresa(pacient.getAdresa());
        pacientDto.setTel(pacient.getTel());
        pacientDto.setEmail(pacient.getEmail());
        pacientDto.setGrupaSange(pacient.getGrupaSange());
        pacientDto.setRh(pacient.getRh());
        pacientDto.setGen(pacient.getGen());
        return pacientDto;
    }

    public List<Pacienti> filterPacienti(String search, String gen, String rh, String grupaSange) {
        List<Pacienti> pacienti = pacientiRepository.findAll();  // Poți obține toți pacienții din baza de date

        if (search != null && !search.isEmpty()) {
            pacienti = pacienti.stream()
                    .filter(p -> p.getNume().contains(search) || p.getPrenume().contains(search))
                    .collect(Collectors.toList());
        }

        if (gen != null && !gen.isEmpty()) {
            pacienti = pacienti.stream()
                    .filter(p -> p.getGen().equals(gen))
                    .collect(Collectors.toList());
        }

        if (rh != null && !rh.isEmpty()) {
            pacienti = pacienti.stream()
                    .filter(p -> p.getRh().equals(rh))
                    .collect(Collectors.toList());
        }

        if (grupaSange != null && !grupaSange.isEmpty()) {
            pacienti = pacienti.stream()
                    .filter(p -> p.getGrupaSange().equals(grupaSange))
                    .collect(Collectors.toList());
        }

        return pacienti;
    }


}
