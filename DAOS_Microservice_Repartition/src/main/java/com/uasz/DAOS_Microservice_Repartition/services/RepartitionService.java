package com.uasz.DAOS_Microservice_Repartition.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uasz.DAOS_Microservice_Repartition.models.Enseignement;
import com.uasz.DAOS_Microservice_Repartition.models.Repartition;
import com.uasz.DAOS_Microservice_Repartition.repositories.RepartitionRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class RepartitionService {
    @Autowired
    private RepartitionRepository repository;
    @Autowired
    private PerService perService;
    @Autowired
    private VacataireService vService;
    @Autowired
    private EnseignementService eService;

    // public void ajouterRepartition(Repartition r ){
    //     r.setDateCreationRepartition(new Date(System.currentTimeMillis()));
    //     repository.save(r);

    // }
    public Repartition ajouter_repartition(Repartition r){
        r.setDateCreationRepartition(new Date(System.currentTimeMillis()));
        return repository.save(r);
    }
    
    public List<Repartition> listerToutRepartition(){
        return repository.findAll();
    }

    public Repartition rechercherRepartition(Long id){
        return repository.findById(id).get();
    }

    public Repartition rechercherRepartitionParId(Long id) {
        Optional<Repartition> optionalRepartition = repository.findById(id);
        if (optionalRepartition.isPresent()) {
            return optionalRepartition.get();
        } else {
            return null;
        }
    }

    public Repartition modifierRepartition(Repartition r){
        Repartition updateRepartition = rechercherRepartition(r.getIdRepartition());
        updateRepartition.setDescriptionRepartition(r.getDescriptionRepartition());
        return repository.save(updateRepartition);
    }

    public void supprimerRepartition(Repartition r){
        repository.delete(r);
    }


    public Repartition modifier_repartition(Repartition r, Long id){
        r.setIdRepartition(id);
        return repository.save(r);
    }

    public void supprimer_repartition(Long id){
        repository.deleteById(id);
    }

    public Enseignement afficherEnseignements(Long id) {
        Repartition r = rechercherRepartition(id);
        return r.getEnseignement();

    }

}
