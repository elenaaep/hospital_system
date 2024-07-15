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
public class Asistent {
    @Id
    @Column(name = "id_asistent")
    private int idAsistent;

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

    @Column(name = "tel", nullable = false, length = 10)
    private int tel;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "tip_asistent", nullable = false)
    private String tipAsistent;

    @Column(name = "etaj", nullable = false)
    private int etaj;
}
