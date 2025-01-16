package com.hospital.hospital_system.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class MesajDTO {

    private Integer pacientId;
    private Integer doctorId;
    private String mesaj;
    private LocalDateTime dataMesaj;

    // Constructori
    public MesajDTO() {
        // Constructor fără parametri
    }

    // Constructor cu parametrii
    public MesajDTO(int pacientId, int doctorId, String mesaj, LocalDateTime dataMesaj) {
        this.pacientId = pacientId;
        this.doctorId = doctorId;
        this.mesaj = mesaj;
        this.dataMesaj = dataMesaj;

    }

    // Getters și Setters
    public int getPacientId() {
        return pacientId;
    }

    public void setPacientId(int pacientId) {
        this.pacientId = pacientId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getMesaj() {
        return mesaj;
    }

    public void setMesaj(String mesaj) {
        this.mesaj = mesaj;
    }

    public LocalDateTime getDataMesaj() {
        return dataMesaj;
    }

    public void setDataMesaj(LocalDateTime dataMesaj) {
        this.dataMesaj = dataMesaj;
    }


}
