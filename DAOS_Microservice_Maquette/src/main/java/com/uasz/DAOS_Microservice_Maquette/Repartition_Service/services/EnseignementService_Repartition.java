package com.uasz.DAOS_Microservice_Maquette.Repartition_Service.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uasz.DAOS_Microservice_Maquette.Repartition_Service.model.Enseignement_Repartition;
import com.uasz.DAOS_Microservice_Maquette.models.Enseignement;
import com.uasz.DAOS_Microservice_Maquette.services.EnseignementService;

/**
 * EnseignementService_Repartition
 */
@Service
public class EnseignementService_Repartition {
    @Autowired
    private EnseignementService enseignementService;

    public List<Enseignement_Repartition> lister_Enseignement_Repartition(){
        List<Enseignement> enseignements = enseignementService.rechercherEnseignements();
        List<Enseignement_Repartition> enseignement_repartitions = new ArrayList<>();
        for (int i = 0; i < enseignements.size(); i++) {
            Enseignement_Repartition enseignement_repartition = new Enseignement_Repartition();
            enseignement_repartition.setId(enseignements.get(i).getIdEnseignement());
            enseignement_repartition.setLibelle(enseignements.get(i).getLibelleEnseignement());
            enseignement_repartition.setDescription(enseignements.get(i).getDescriptionEnseignement());
            enseignement_repartition.setIdModule(enseignements.get(i).getModule().getIdModule());
            enseignement_repartition.setCours(enseignements.get(i).getModule().getCoursModule());
            enseignement_repartition.setCoefficient(enseignements.get(i).getModule().getCoefficientModule());
            enseignement_repartition.setNbreHeure(enseignements.get(i).getModule().getDureeModule());
            enseignement_repartition.setIdClasse(enseignements.get(i).getClasse().getIdClasse());
            enseignement_repartition.setClasse(enseignements.get(i).getClasse().getLibelleClasse());

            if (enseignements.get(i).getGroupe() != null) {
                enseignement_repartition.setIdGroupe(enseignements.get(i).getGroupe().getIdGroupe());
                enseignement_repartition.setGroupe(enseignements.get(i).getGroupe().getLibelleGroupe());
                
            }

            enseignement_repartition.setSemestre(enseignements.get(i).getClasse().getSemestre().getLibelleSemestre());
            enseignement_repartitions.add(enseignement_repartition);

        } 
        
        return enseignement_repartitions;
    }

    
}