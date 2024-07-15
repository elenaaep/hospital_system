package com.hospital.hospital_system.repository;

import com.hospital.hospital_system.models.Istoric_Pacienti;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IstoricPacientiRepository extends JpaRepository<Istoric_Pacienti, Integer> {

    Optional<Istoric_Pacienti> findByIdPacient(int idPacient);
}
