package com.hospital.hospital_system.repository;

import com.hospital.hospital_system.models.AnalizeMedicale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AnalizeMedicaleRepository extends JpaRepository<AnalizeMedicale, Integer> {
    Optional<AnalizeMedicale> findByTipAnaliza(String tipAnaliza);
}
