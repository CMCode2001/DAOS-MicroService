package com.uasz.DAOS_Microservice_EmploiDuTemps.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Repartition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private Long idEnseignant;
    private String nomEnseignant;
    private String prenomEnseignant;
    private Long idEnseignement;
    private String LibelleEnseignement;
    private Long idModule;
    private String cours;
    private int nbreHeure;
    private Long idClasse;
    private String classe;
    private Long idGroupe;
    private String groupe;
    private String semestre;

    @JsonIgnore
    @OneToMany(mappedBy = "repartition",  fetch = FetchType.LAZY)
    private List<Seance> seances;
}
