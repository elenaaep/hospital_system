package com.hospital.hospital_system.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class IstoricPacienti {

    @Id
    @Column(name = "id_ist")
    private int idIst;

    @Column(name = "id_pacient", nullable = false)
    private int idPacient;

    @Column(name = "id_programare")
    private Integer idProgramare;

    @Column(name = "id_internare")
    private Integer idInternare;

    @Column(name = "id_doc")
    private Integer idDoc;

    @Column(name = "id_analize")
    private Integer idAnalize;

    @Column(name = "id_tratament")
    private Integer idTratament;

    @Column(name = "observatii", nullable = false)
    private String observatii;

    // Getters and Setters
    public int getIdIst() {
        return idIst;
    }

    public void setIdIst(int idIst) {
        this.idIst = idIst;
    }

    public int getIdPacient() {
        return idPacient;
    }

    public void setIdPacient(int idPacient) {
        this.idPacient = idPacient;
    }

    public Integer getIdProgramare() {
        return idProgramare;
    }

    public void setIdProgramare(Integer idProgramare) {
        this.idProgramare = idProgramare;
    }

    public Integer getIdInternare() {
        return idInternare;
    }

    public void setIdInternare(Integer idInternare) {
        this.idInternare = idInternare;
    }

    public Integer getIdDoc() {
        return idDoc;
    }

    public void setIdDoc(Integer idDoc) {
        this.idDoc = idDoc;
    }

    public Integer getIdAnalize() {
        return idAnalize;
    }

    public void setIdAnalize(Integer idAnalize) {
        this.idAnalize = idAnalize;
    }

    public Integer getIdTratament() {
        return idTratament;
    }

    public void setIdTratament(Integer idTratament) {
        this.idTratament = idTratament;
    }

    public String getObservatii() {
        return observatii;
    }

    public void setObservatii(String observatii) {
        this.observatii = observatii;
    }
}
