package com.hospital.hospital_system.models;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Garda {

    @Id
    @Column(name = "id_garda")
    private int idGarda;

    @Column(name = "id_doc")
    private Integer idDoc;

    @Column(name = "id_asistent")
    private Integer idAsistent;

    @Column(name = "pers_tip", nullable = false)
    private String persTip;

    @Column(name = "data_inceput", nullable = false)
    private Date dataInceput;

    @Column(name = "data_sfarsit", nullable = false)
    private Date dataSfarsit;

    @Column(name = "nr_pacienti_ingrijiti", nullable = false)
    private int nrPacientiIngrijiti;

    @Column(name = "consumabile_folosite", nullable = false)
    private String consumabileFolosite;
}
