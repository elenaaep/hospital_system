package com.hospital.hospital_system.repository;

import com.hospital.hospital_system.models.Mesaj;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MesajRepository extends JpaRepository<Mesaj, Long> {


}
