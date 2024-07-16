package com.hospital.hospital_system.service;

import com.hospital.hospital_system.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<UserDto> findAllUser();
}
