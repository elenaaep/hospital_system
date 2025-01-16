package com.hospital.hospital_system.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Mesaj {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMesaj;

    @ManyToOne
    @JoinColumn(name = "id_pacient", nullable = false)  // Corectăm numele coloanei pentru claritate
    private Pacienti pacient;

    @ManyToOne
    @JoinColumn(name = "id_doctor", nullable = false)  // Corectăm numele coloanei pentru claritate
    private Doctor doctor;

    @Column(nullable = false)
    private String mesaj;

    @Column(nullable = false)
    private LocalDateTime dataTrimitere;



    // Constructori, getters și setters
    public Mesaj() {}

    public Mesaj(Pacienti pacient, Doctor doctor, String mesaj,  LocalDateTime dataTrimitere) {
        this.pacient = pacient;
        this.doctor = doctor;
        this.mesaj = mesaj;

        this.dataTrimitere = dataTrimitere;
    }

    // Getters și setters
    public Long getIdMesaj() {
        return idMesaj;
    }

    public void setIdMesaj(Long idMesaj) {
        this.idMesaj = idMesaj;
    }

    public Pacienti getPacient() {
        return pacient;
    }

    public void setPacient(Pacienti pacient) {
        this.pacient = pacient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public String getMesaj() {
        return mesaj;
    }

    public void setMesaj(String mesaj) {
        this.mesaj = mesaj;
    }

    public LocalDateTime getDataTrimitere() {
        return dataTrimitere;
    }

    public void setDataTrimitere(LocalDateTime dataTrimitere) {
        this.dataTrimitere = dataTrimitere;
    }


}