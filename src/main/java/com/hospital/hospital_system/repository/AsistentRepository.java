package com.hospital.hospital_system.repository;

import com.hospital.hospital_system.models.Asistent;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AsistentRepository extends JpaRepository<Asistent, Integer> {

    Optional<Asistent> findByCnp(String cnp);
}
