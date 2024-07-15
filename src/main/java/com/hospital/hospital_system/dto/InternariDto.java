package com.hospital.hospital_system.dto;

import lombok.Builder;
import lombok.Data;

import java.sql.Date;

@Data
@Builder
public class InternariDto {
    private int idInternare;
    private int idPacient;
    private Date data;
    private String motiv;
    private String greutate;
    private String puls;
    private String tensiune;
    private boolean bolnavCronic;
    private String alergii;
    private String diagnostic;
    private String observatii;
}
