package com.hospital.hospital_system.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class IstoricPacientiDto {
    private int idIst;
    private int idPacient;
    private Integer idProgramare;
    private Integer idInternare;
    private Integer idDoc;
    private Integer idAnalize;
    private Integer idTratament;
    private String observatii;
}
