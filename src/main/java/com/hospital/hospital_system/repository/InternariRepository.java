package com.hospital.hospital_system.repository;

import com.hospital.hospital_system.models.Internari;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InternariRepository extends JpaRepository<Internari, Long> {

    Optional<Internari> findByIdPacient(Long aLong);
}
