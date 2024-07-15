package com.hospital.hospital_system.repository;

import com.hospital.hospital_system.models.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    Optional<Doctor> findByCnp(String cnp);
}
