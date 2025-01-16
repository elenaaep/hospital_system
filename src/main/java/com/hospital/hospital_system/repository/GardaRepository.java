package com.hospital.hospital_system.repository;

import com.hospital.hospital_system.models.Garda;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface GardaRepository extends JpaRepository<Garda, Integer> {

    Optional<Garda> findByIdAsistentAndIdDoc(int idAsistent, int idDoc);
    // Interogare pentru a obține gărzi între două date
    List<Garda> findByDataInceputBetween(LocalDate startDate, LocalDate endDate);
}
