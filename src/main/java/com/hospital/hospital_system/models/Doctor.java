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
public class Doctor {
    @Id
    @Column(name = "id_doc")
    private int idDoc;

    @Column(name = "titlu", nullable = false)
    private String titlu;

    @Column(name = "nume", nullable = false)
    private String nume;

    @Column(name = "prenume", nullable = false)
    private String prenume;

    @Column(name = "CNP", nullable = false, length = 13)
    private String cnp;

    @Column(name = "data_nasterii", nullable = false)
    private Date dataNasterii;

    @Column(name = "gen", nullable = false)
    private String gen;

    @Column(name = "tel", nullable = false, length = 10)
    private int tel;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "departament", nullable = false)
    private String departament;

    @Column(name = "specializare", nullable = false)
    private String specializare;

    @Column(name = "etaj", nullable = false)
    private int etaj;

    @Column(name = "competente", nullable = false, length = 1000)
    private String competente;
}
