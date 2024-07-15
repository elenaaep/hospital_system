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
public class Internari {
    @Id
    @Column(name = "id_internare")
    private int idInternare;

    @Column(name = "id_pacient", nullable = false)
    private int idPacient;

    @Column(name = "data", nullable = false)
    private Date data;

    @Column(name = "motiv", nullable = false)
    private String motiv;

    @Column(name = "greutate", nullable = false)
    private String greutate;

    @Column(name = "puls", nullable = false)
    private String puls;

    @Column(name = "tensiune", nullable = false)
    private String tensiune;

    @Column(name = "bolnav_cronic", nullable = false)
    private boolean bolnavCronic;

    @Column(name = "alergii", nullable = false)
    private String alergii;

    @Column(name = "diagnostic", nullable = false)
    private String diagnostic;

    @Column(name = "observatii", nullable = false)
    private String observatii;
}
