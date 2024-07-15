package com.hospital.hospital_system.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Time;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Programari {

    // Getters and Setters
    @Id
    @Column(name = "id_programare")
    private int idProgramare;

    @Column(name = "id_pacient", nullable = false)
    private int idPacient;

    @Column(name = "id_doc", nullable = false)
    private int idDoc;

    @Column(name = "data_programare", nullable = false)
    private Date dataProgramare;

    @Column(name = "ora", nullable = false)
    private Time ora;

    @Column(name = "motiv", nullable = false)
    private String motiv;

    public void setIdProgramare(int idProgramare) {
        this.idProgramare = idProgramare;
    }

    public void setIdPacient(int idPacient) {
        this.idPacient = idPacient;
    }

    public void setIdDoc(int idDoc) {
        this.idDoc = idDoc;
    }

    public void setDataProgramare(Date dataProgramare) {
        this.dataProgramare = dataProgramare;
    }

    public void setOra(Time ora) {
        this.ora = ora;
    }

    public void setMotiv(String motiv) {
        this.motiv = motiv;
    }

}
