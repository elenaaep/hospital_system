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
        List<Garda> garda = gardaRepository.findAll();
        return garda.stream()
                .map(garda1 -> mapToGarda(garda1))
                .collect(Collectors.toList());
    }


    private GardaDto mapToGarda(Garda garda1) {
        GardaDto gardaDto = GardaDto.builder()
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

    private Garda mapToEntity(GardaDto gardaDto) {
        // Mapează DTO-ul într-o entitate Garda
        return new Garda(
                gardaDto.getIdGarda(),
                gardaDto.getIdDoc(),
                gardaDto.getIdAsistent(),
                gardaDto.getPersTip(),
                gardaDto.getDataInceput(),
                gardaDto.getDataSfarsit(),
                gardaDto.getNrPacientiIngrijiti(),
                gardaDto.getConsumabileFolosite()
        );
    }


    @Override
    public void addGarda(GardaDto gardaDto) {
        // Verifică dacă consumabilele folosite sunt nule și setează o valoare implicită
        if (gardaDto.getConsumabileFolosite() == null || gardaDto.getConsumabileFolosite().isEmpty()) {
            gardaDto.setConsumabileFolosite("N/A");  // Valoare default
        }

        // Creează un obiect Garda din DTO și salvează-l
        Garda gardaEntity = mapToEntity(gardaDto);
        gardaRepository.save(gardaEntity);  // Salvează garda în repo
    }

    @Override
    public void deleteGarda(int id_garda) {
        gardaRepository.deleteById(id_garda); // Ștergem gardă din baza de date
    }

    @Override
    public GardaDto findById(int id) {
        Garda garda = gardaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Garda nu a fost găsită"));
        return mapToGardaDto(garda);
    }

    @Override
    public void updateGarda(int id, GardaDto gardaDto) {
        // Găsește garda existentă
        Garda garda = gardaRepository.findById(id).orElseThrow(() -> new RuntimeException("Garda not found"));

        // Actualizează câmpurile gărzii
        garda.setIdDoc(gardaDto.getIdDoc());
        garda.setIdAsistent(gardaDto.getIdAsistent());
        garda.setPersTip(gardaDto.getPersTip());
        garda.setDataInceput(gardaDto.getDataInceput());
        garda.setDataSfarsit(gardaDto.getDataSfarsit());
        garda.setNrPacientiIngrijiti(gardaDto.getNrPacientiIngrijiti());
        garda.setConsumabileFolosite(gardaDto.getConsumabileFolosite());

        gardaRepository.save(garda);  // Salvează modificările
    }

    @Override
    public List<GardaDto> searchGarda(String searchTerm, Integer idDoc, Integer idAsistent, String persTip) {
        return List.of();
    }

    private GardaDto mapToGardaDto(Garda garda) {
        return GardaDto.builder()
                .idGarda(garda.getIdGarda())
                .idDoc(garda.getIdDoc())
                .idAsistent(garda.getIdAsistent())
                .persTip(garda.getPersTip())
                .dataInceput(garda.getDataInceput())
                .dataSfarsit(garda.getDataSfarsit())
                .nrPacientiIngrijiti(garda.getNrPacientiIngrijiti())
                .consumabileFolosite(garda.getConsumabileFolosite())
                .build();
    }

    @Override
    public List<GardaDto> searchGarda(String searchTerm, int idDoc, int idAsistent, String persTip) {
        List<Garda> garda = gardaRepository.findAll();

        return garda.stream()
                .filter(g -> {
                    boolean matchesSearchTerm = (searchTerm == null || searchTerm.isEmpty()) ||
                            g.getIdDoc().toString().contains(searchTerm) ||
                            g.getIdAsistent().toString().contains(searchTerm) ||
                            g.getPersTip().toLowerCase().contains(searchTerm.toLowerCase());

                    boolean matchesIdDoc = (idDoc == 0 || g.getIdDoc() == idDoc);  // Verifică dacă idDoc este 0
                    boolean matchesIdAsistent = (idAsistent == 0 || g.getIdAsistent() == idAsistent);  // Verifică dacă idAsistent este 0
                    boolean matchesPersTip = (persTip == null || persTip.isEmpty() || g.getPersTip().equalsIgnoreCase(persTip));

                    return matchesSearchTerm && matchesIdDoc && matchesIdAsistent && matchesPersTip;
                })
                .map(this::mapToGardaDto)
                .collect(Collectors.toList());
    }

    @Override
    public void saveGarda(Garda garda) {
        if (garda.getIdGarda() == 0) {
            throw new IllegalArgumentException("ID-ul gărzii nu poate fi 0.");
        }
        if (garda.getIdDoc() != null && garda.getIdAsistent() != null) {
            // Salvează garda doar dacă ambele sunt prezente
            gardaRepository.save(garda);
        } else {
            // Permite salvarea dacă unul dintre ID-uri este null
            gardaRepository.save(garda);
        }
    }

}
