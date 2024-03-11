package com.uasz.DAOS_Microservice_Repartition.EmploiDuTemps_Service.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uasz.DAOS_Microservice_Repartition.EmploiDuTemps_Service.model.Repartition_Emploi;
import com.uasz.DAOS_Microservice_Repartition.models.Enseignant;
import com.uasz.DAOS_Microservice_Repartition.models.Repartition;
import com.uasz.DAOS_Microservice_Repartition.services.RepartitionService;


@Service
public class RepartitionService_Emploi {
    @Autowired
    private RepartitionService rService;

    public List<Repartition_Emploi> lister_Repartition_Emploi(){
        List<Repartition> repartitions = rService.listerToutRepartition();
        List<Repartition_Emploi> repartition_emplois = new ArrayList<>();
        for (int i = 0; i < repartitions.size(); i++) {
            Repartition_Emploi repartition_emploi = new Repartition_Emploi();
            repartition_emploi.setId(repartitions.get(i).getIdRepartition());
            repartition_emploi.setDescription(repartitions.get(i).getDescriptionRepartition());
            repartition_emploi.setIdEnseignement(repartitions.get(i).getEnseignement().getId());
            repartition_emploi.setLibelleEnseignement(repartitions.get(i).getEnseignement().getLibelle());
            repartition_emploi.setIdModule(repartitions.get(i).getEnseignement().getIdModule());
            repartition_emploi.setCours(repartitions.get(i).getEnseignement().getCours());
            repartition_emploi.setNbreHeure(repartitions.get(i).getEnseignement().getNbreHeure());
            repartition_emploi.setIdClasse(repartitions.get(i).getEnseignement().getIdClasse());
            repartition_emploi.setClasse(repartitions.get(i).getEnseignement().getClasse());
            repartition_emploi.setIdGroupe(repartitions.get(i).getEnseignement().getIdGroupe());
            repartition_emploi.setGroupe(repartitions.get(i).getEnseignement().getGroupe());
            repartition_emploi.setSemestre(repartitions.get(i).getEnseignement().getSemestre());

            Enseignant enseignant = repartitions.get(i).getEnseignant();
            if (enseignant != null) {
                repartition_emploi.setIdEnseignant(enseignant.getIdEns());
                repartition_emploi.setNomEnseignant(enseignant.getNomEns());
                repartition_emploi.setPrenomEnseignant(enseignant.getPrenomEns());
            }

            repartition_emplois.add(repartition_emploi);
        }
        
        return repartition_emplois;
    }


}
