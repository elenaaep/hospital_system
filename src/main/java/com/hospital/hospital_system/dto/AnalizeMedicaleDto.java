package com.hospital.hospital_system.dto;

import lombok.Builder;
import lombok.Data;

import java.sql.Date;

@Data
@Builder
public class AnalizeMedicaleDto {

    private int idAnalize;
    private int idPacient;
    private int idDoc;
    private String tipAnaliza;
    private Date dataEfectuare;
    private String rezultate;
    private String valoriNormale;
    private String executantAnalize;
    private String observatii;
}
