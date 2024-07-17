package com.hospital.hospital_system.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Analize_Medicale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_analize")
    private int idAnalize;

    @Column(name = "id_pacient", nullable = false)
    private int idPacient;

    @Column(name = "id_doc", nullable = false)
    private int idDoc;

    @Column(name = "tip_analiza", nullable = false, length = 255)
    private String tipAnaliza;

    @Column(name = "data_efectuare", nullable = false)
    private LocalDate dataEfectuare;

    @Column(name = "rezultate", nullable = false, length = 1024)
    private String rezultate;

    @Column(name = "valori_normale", nullable = false, length = 1024)
    private String valoriNormale;

    @Column(name = "executant_analize", nullable = false, length = 255)
    private String executantAnalize;

    @Column(name = "observatii", nullable = true, length = 1024)
    private String observatii;
}
