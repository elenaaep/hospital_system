package com.hospital.hospital_system.repository;

import com.hospital.hospital_system.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {

    Optional<User> findByIdUser(String idUser);
    Optional<User> findByUsername(String username);  // Update this method name
    boolean existsByUsername(String username);  // Update this method name
}

