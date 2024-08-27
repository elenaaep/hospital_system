package com.hospital.hospital_system.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class User {

    @Id
    @Column(name = "id_user")
    private String idUser;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "parola", nullable = false)
    private String parola;

    @Column(name = "utip", nullable = false)
    private String utip;

    // Getters and Setters
    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    public String getUtip() {
        return utip;
    }

    public void setUtip(String utip) {
        this.utip = utip;
    }
}

