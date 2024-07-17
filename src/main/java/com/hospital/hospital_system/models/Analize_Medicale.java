package com.hospital.hospital_system.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Analize_Medicale {
    @Id
    @Column(name = "id_analize")
    private int idAnalize;

    @Column(name = "id_pacient", nullable = false)
    private int idPacient;

    @Column(name = "id_doc", nullable = false)
    private int idDoc;

    @Column(name = "tip_analiza", nullable = false)
    private String tipAnaliza;

    @Column(name = "data_efectuare", nullable = false)
    private Date dataEfectuare;

    @Column(name = "rezultate", nullable = false)
    private String rezultate;

    @Column(name = "valori_normale", nullable = false)
    private String valoriNormale;

    @Column(name = "executant_analize", nullable = false)
    private String executantAnalize;

    @Column(name = "observatii", nullable = false)
    private String observatii;
}
