package com.hospital.hospital_system.repository;

import com.hospital.hospital_system.models.Pacienti;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PacientiRepository extends JpaRepository<Pacienti, Integer> {
    Optional<Pacienti> findByIdPacient(int idPacient);
}
