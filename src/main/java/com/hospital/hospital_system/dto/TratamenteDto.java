package com.hospital.hospital_system.dto;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;

import java.sql.Date;
import java.sql.Time;

@Data
@Builder
public class TratamenteDto {

    private int idTratament;
    private int idPacient;
    private String denumireTratament;
    private String doza;
    private Date dataInceput;
    private Time ora;
    private Date dataSfarsit;
    private String observatii;
}
