package com.hospital.hospital_system.repository;

import com.hospital.hospital_system.models.Tratamente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TratamenteRepository extends JpaRepository<Tratamente, Integer> {

    Optional<Tratamente> findByIdPacient(int idPacient);
}
