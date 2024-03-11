package com.uasz.DAOS_Microservice_Repartition.EmploiDuTemps_Service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Repartition_Emploi {
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
}
