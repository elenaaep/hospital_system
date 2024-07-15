package com.hospital.hospital_system.repository;

import com.hospital.hospital_system.models.Garda;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GardaRepository extends JpaRepository<Garda, Long> {

    Optional<Garda> findByIdAsistentAndIdDoc(Long aLong);
}
