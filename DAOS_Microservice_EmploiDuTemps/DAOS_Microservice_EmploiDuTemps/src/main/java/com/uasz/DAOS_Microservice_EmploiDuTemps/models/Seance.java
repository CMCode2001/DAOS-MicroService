package com.uasz.DAOS_Microservice_EmploiDuTemps.models;

import java.util.Date;

import com.uasz.DAOS_Microservice_EmploiDuTemps.constantes.Jour;

//import com.uasz.Gestion_DAOS.Modele.repartition.Repartition;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Seance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSeance;
    private Jour jourSeance;
    private int dureeSeance;
    private int debutSeance, finSeance, numeroSeance;
    @Temporal(TemporalType.DATE)
    private Date dateCreationSeance;
    /**
     * Representation de la relation Salle-Seance
     */
    @ManyToOne
    @JoinColumn(name = "salle")
    private Salle salle;

    /**
     * Representation de la relation Seance-Deroulement
     */
    @OneToOne(mappedBy = "seance")
    private Deroulement deroulement;

    /**
     * Representation de la relation Emploi-Seance
     */
    @ManyToOne
    @JoinColumn(name = "emploi", nullable = false)
    private Emploi emploi;

   /* @ManyToOne
    @JoinColumn(name = "repartition")
    private Repartition repartition;*/
}
