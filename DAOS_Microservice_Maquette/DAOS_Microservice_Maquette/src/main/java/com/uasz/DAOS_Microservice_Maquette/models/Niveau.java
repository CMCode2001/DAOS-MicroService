package com.uasz.DAOS_Microservice_Maquette.models;


import java.util.Date;
import java.util.List;

import com.uasz.DAOS_Microservice_Maquette.constante.NiveauConst;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Niveau {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idNiveau;
    private NiveauConst libelleNiveau;
    private String descriptionNiveau;
    @Temporal(TemporalType.DATE)
    private Date dateCreationNiveau;

    /**
     * Representation de la relation Niveau-Cycle;
     */

    @ManyToOne
    @JoinColumn(name = "cycle")
    private Cycle cycle;

    /**
     * Representation de la relation Niveau-Formation;
     */
    @OneToMany(mappedBy = "niveau")
    private List <Formation> formations;
}