package com.hospital.hospital_system.repository;

import com.hospital.hospital_system.models.Internari;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface InternariRepository extends JpaRepository<Internari, Integer> {

    Optional<Internari> findByIdPacient(int idPacient);
}
