package com.hospital.hospital_system.repository;

import com.hospital.hospital_system.models.Analize_Medicale;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AnalizeMedicaleRepository extends JpaRepository<Analize_Medicale, Long> {
    Optional<Analize_Medicale> findByTipAnaliza(String tipAnaliza);
}
