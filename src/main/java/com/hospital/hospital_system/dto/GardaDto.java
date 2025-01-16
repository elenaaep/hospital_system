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

    public GardaDto(int idGarda, Integer idDoc, Integer idAsistent, String persTip, java.sql.Date dataInceput,
                    java.sql.Date dataSfarsit, int nrPacientiIngrijiti, String consumabileFolosite) {
        this.idGarda = idGarda;
        this.idDoc = idDoc;
        this.idAsistent = idAsistent;
        this.persTip = persTip;
        this.dataInceput = dataInceput;
        this.dataSfarsit = dataSfarsit;
        this.nrPacientiIngrijiti = nrPacientiIngrijiti;
        this.consumabileFolosite = consumabileFolosite;
    }
    public GardaDto() {}

}
