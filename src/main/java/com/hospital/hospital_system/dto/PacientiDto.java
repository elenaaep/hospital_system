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
    private String cnp;
    private Date dataNasterii;
    private String gen;
    private int varsta;
    private String adresa;
    private int tel;
    private String email;
    private String grupaSange;
    private String rh;

    public PacientiDto() {}
    // Constructor complet parametrizat
    public PacientiDto(int idPacient, String nume, String prenume, String cnp, Date dataNasterii,
                       String gen, int varsta, String adresa, int tel, String email,
                       String grupaSange, String rh) {
        this.idPacient = idPacient;
        this.nume = nume;
        this.prenume = prenume;
        this.cnp = cnp;
        this.dataNasterii = dataNasterii;
        this.gen = gen;
        this.varsta = varsta;
        this.adresa = adresa;
        this.tel = tel;
        this.email = email;
        this.grupaSange = grupaSange;
        this.rh = rh;
    }

}
