package com.hospital.hospital_system.dto;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;

import java.sql.Date;
import java.sql.Time;

@Data
@Builder
public class ProgramariDto {

    private int idProgramare;
    private int idPacient;
    private int idDoc;
    private Date dataProgramare;
    private Time ora;
    private String motiv;

}
