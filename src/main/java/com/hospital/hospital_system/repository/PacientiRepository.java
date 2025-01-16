package com.hospital.hospital_system.repository;

import com.hospital.hospital_system.models.Pacienti;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PacientiRepository extends JpaRepository<Pacienti, Integer> {
    Optional<Pacienti> findByIdPacient(int idPacient);
    Optional<Pacienti> findByGrupaSangeAndRh(String grupaSange, String rh);
    Optional<Pacienti> findByGrupaSange(String grupaSange);
    Optional<Pacienti> findByRh(String rh);

    @Query("SELECT p FROM Pacienti p WHERE " +
            "(:searchTerm IS NULL OR LOWER(p.nume) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR LOWER(p.prenume) LIKE LOWER(CONCAT('%', :searchTerm, '%'))) AND " +
            "(:gen IS NULL OR p.gen = :gen) AND " +
            "(:rh IS NULL OR p.rh = :rh) AND " +
            "(:grupaSange IS NULL OR p.grupaSange = :grupaSange)")
    List<Pacienti> findByFilters(@Param("searchTerm") String searchTerm,
                                 @Param("gen") String gen,
                                 @Param("rh") String rh,
                                 @Param("grupaSange") String grupaSange);

    List<Pacienti> findByGenAndRhAndGrupaSange(String gen, String rh, String grupaSange);
}

