package com.uasz.DAOS_Microservice_Maquette.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//importation Lomboks
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

//importation des classes
import com.uasz.DAOS_Microservice_Maquette.models.Enseignement;
import com.uasz.DAOS_Microservice_Maquette.repositories.EnseignementRepository;

@Service
@Transactional
@AllArgsConstructor
public class EnseignementService {
    @Autowired
    private EnseignementRepository eRepository;

    public void ajouterEnseignement(Enseignement ens){
        ens.setDateCreationEnseignement(new Date(System.currentTimeMillis()));
        eRepository.save(ens);
    }

    public List<Enseignement> rechercherEnseignements(){
        return eRepository.findAll();
    }

    public Enseignement rechercherUneEnseignement(Long idEns){
        return eRepository.findById(idEns).get();
    }

    public Enseignement modifierEnseignement(Enseignement ens){
        Enseignement e = rechercherUneEnseignement(ens.getIdEnseignement());
        e.setObjectifsEnseignement(ens.getObjectifsEnseignement());
        e.setDescriptionEnseignements(ens.getDescriptionEnseignements());
        return eRepository.save(e);
    }

    public void supprimerEnseignement(Enseignement ens){
        eRepository.delete(ens);
    }

    public Enseignement ajouter_enseignement( Enseignement e){
        e.setDateCreationEnseignement(new Date(System.currentTimeMillis()));
        return eRepository.save(e);
    }

    public Enseignement modifier_enseignement(Enseignement e, Long id){
        e.setIdEnseignement(id);
        return eRepository.save(e);
    }

    public void supprimer_enseignement(Long id){
        eRepository.deleteById(id);
    }

}
