package com.hospital.hospital_system.dto;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {

    private String id_user;
    private String uname;
    private String parola;
    private String utip;
}
