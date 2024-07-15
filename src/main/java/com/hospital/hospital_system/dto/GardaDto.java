package com.hospital.hospital_system.dto;

import lombok.Builder;
import lombok.Data;

import java.sql.Date;

@Data
@Builder
public class GardaDto {

    private int idGarda;
    private Integer idDoc;
    private Integer idAsistent;
    private String persTip;
    private Date dataInceput;
    private Date dataSfarsit;
    private int nrPacientiIngrijiti;
    private String consumabileFolosite;
}
