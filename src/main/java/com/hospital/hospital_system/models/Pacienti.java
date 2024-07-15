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
public class Pacienti {
    @Id
    @Column(name = "id_pacient")
    private int idPacient;

    @Column(name = "nume", nullable = false)
    private String nume;

    @Column(name = "prenume", nullable = false)
    private String prenume;

    @Column(name = "cnp", nullable = false, length = 13)
    private String cnp;

    @Column(name = "data_nasterii", nullable = false)
    private Date dataNasterii;

    @Column(name = "gen", nullable = false)
    private String gen;

    @Column(name = "varsta", nullable = false)
    private int varsta;

    @Column(name = "adresa", nullable = false, length = 500)
    private String adresa;

    @Column(name = "tel", nullable = false)
    private int tel;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "grupa_sange", nullable = false)
    private String grupaSange;

    @Column(name = "rh", nullable = false)
    private String rh;
}
