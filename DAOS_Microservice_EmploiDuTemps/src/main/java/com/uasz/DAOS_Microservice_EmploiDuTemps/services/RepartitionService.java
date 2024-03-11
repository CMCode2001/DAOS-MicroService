package com.uasz.DAOS_Microservice_EmploiDuTemps.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uasz.DAOS_Microservice_EmploiDuTemps.models.Repartition;
import com.uasz.DAOS_Microservice_EmploiDuTemps.models.Seance;
import com.uasz.DAOS_Microservice_EmploiDuTemps.repositories.RepartitionRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class RepartitionService {
    
        
    @Autowired
    private RepartitionRepository repository;

    
    public List<Repartition> lister_Repartitions(){
        return repository.findAll();
    }

    public Repartition rechercher_Repartition(Long id){
        return repository.findById(id).get();
    }

    public Repartition ajouter_Repartition(Repartition enseignement){
        return repository.save(enseignement);
    }

    public Repartition modifier_Repartition(Repartition enseignement, Long id){
        enseignement.setId(id);
        return repository.save(enseignement);
    }

    public void suppimer_Repartition(Long id){
        repository.deleteById(id);
    }


    public List<Seance> afficherSeances(Long id){
        Repartition e = rechercher_Repartition(id);
        return e.getSeances();
    }
    

}
