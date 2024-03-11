package com.uasz.DAOS_Microservice_Maquette.Repartition_Service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Enseignement_Repartition {
    private Long id;
    private String libelle;
    private String description;
    private Long idModule;
    private String cours;
    private int  coefficient;
    private int nbreHeure;
    private Long idClasse;
    private String classe;
    private Long idGroupe;
    private String groupe;
    private String semestre;
}   
