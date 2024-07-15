package com.hospital.hospital_system.models;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.sql.Time;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Tratamente {

    @Id
    @Column(name = "id_tratament")
    private int idTratament;

    @Column(name = "id_pacient", nullable = false)
    private int idPacient;

    @Column(name = "denumire_tratament", nullable = false)
    private String denumireTratament;

    @Column(name = "doza", nullable = false)
    private String doza;

    @Column(name = "data_inceput", nullable = false)
    private Date dataInceput;

    @Column(name = "ora", nullable = false)
    private Time ora;

    @Column(name = "data_sfarsit", nullable = false)
    private Date dataSfarsit;

    @Column(name = "observatii", nullable = false)
    private String observatii;

    // Getters and Setters
    public void setIdTratament(int idTratament) {
        this.idTratament = idTratament;
    }

    public void setIdPacient(int idPacient) {
        this.idPacient = idPacient;
    }

    public void setDenumireTratament(String denumireTratament) {
        this.denumireTratament = denumireTratament;
    }

    public void setDoza(String doza) {
        this.doza = doza;
    }

    public void setDataInceput(Date dataInceput) {
        this.dataInceput = dataInceput;
    }

    public void setOra(Time ora) {
        this.ora = ora;
    }

    public void setDataSfarsit(Date dataSfarsit) {
        this.dataSfarsit = dataSfarsit;
    }

    public void setObservatii(String observatii) {
        this.observatii = observatii;
    }
}
