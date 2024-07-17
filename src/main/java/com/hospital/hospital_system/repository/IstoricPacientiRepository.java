package com.hospital.hospital_system.repository;

import com.hospital.hospital_system.models.IstoricPacienti;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IstoricPacientiRepository extends JpaRepository<IstoricPacienti, Integer> {

    Optional<IstoricPacienti> findByIdPacient(int idPacient);
}
