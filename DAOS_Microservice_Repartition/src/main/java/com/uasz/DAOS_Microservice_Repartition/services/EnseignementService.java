package com.uasz.DAOS_Microservice_Repartition.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uasz.DAOS_Microservice_Repartition.models.Enseignement;
import com.uasz.DAOS_Microservice_Repartition.models.Repartition;
import com.uasz.DAOS_Microservice_Repartition.repositories.EnseignementRepository;

//importation Lomboks
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

//importation des classes


@Service
@Transactional
@AllArgsConstructor
public class EnseignementService {
    
    @Autowired
    private EnseignementRepository enseignementRepository;

    
    public List<Enseignement> lister_Enseignements(){
        return enseignementRepository.findAll();
    }

    public Enseignement rechercher_Enseignement(Long id){
        return enseignementRepository.findById(id).get();
    }

    public Enseignement ajouter_Enseignement(Enseignement enseignement){
        return enseignementRepository.save(enseignement);
    }

    public Enseignement modifier_Enseignement(Enseignement enseignement, Long id){
        enseignement.setId(id);
        return enseignementRepository.save(enseignement);
    }

    public void suppimer_Enseignement(Long id){
        enseignementRepository.deleteById(id);
    }


    public List<Repartition> afficherRepartitions(Long id){
        Enseignement e = rechercher_Enseignement(id);
        return e.getRepartitions();
    }

}
