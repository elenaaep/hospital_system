package com.hospital.hospital_system.dto;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;

import java.sql.Date;

@Data
@Builder
public class DoctorDto {
    private int idDoc;
    private String titlu;
    private String nume;
    private String prenume;
    private String cnp;
    private Date dataNasterii;
    private String gen;
    private int tel;
    private String email;
    private String departament;
    private String specializare;
    private int etaj;
    private String competente;
}
