package com.hospital.hospital_system.repository;

import com.hospital.hospital_system.models.Programari;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProgramariRepository extends JpaRepository<Programari, Integer> {

    Optional<Programari> findByIdProgramare(int idProgramare);
}
