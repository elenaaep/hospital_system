package com.hospital.hospital_system.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {

    private String id_user;
    @NotEmpty
    private String uname;
    @NotEmpty
    private String parola;
    private String utip;
}
