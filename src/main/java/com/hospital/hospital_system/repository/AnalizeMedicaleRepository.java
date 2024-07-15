package com.hospital.hospital_system.repository;

import com.hospital.hospital_system.models.Analize_Medicale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AnalizeMedicaleRepository extends JpaRepository<Analize_Medicale, Integer> {
    Optional<Analize_Medicale> findByTipAnaliza(String tipAnaliza);
}
