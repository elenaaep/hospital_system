package com.hospital.hospital_system.dto;

import lombok.Builder;
import lombok.Data;

import java.sql.Date;

@Data
@Builder
public class PacientiDto {
    private int idPacient;
    private String nume;
    private String prenume;
    private Date dataNasterii;
    private String gen;
    private int varsta;
    private String adresa;
    private int tel;
    private String email;
    private String grupaSange;
    private String rh;
}
