package com.hospital.hospital_system.dto;

import lombok.Builder;
import lombok.Data;

import java.sql.Date;

@Data
@Builder
public class AsistentDto {
    private int idAsistent;
    private String nume;
    private String prenume;
    private String cnp;
    private Date dataNasterii;
    private String gen;
    private int tel;
    private String email;
    private String tipAsistent;
    private int etaj;
}
