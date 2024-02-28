package com.uasz.DAOS_Microservice_Maquette.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


//importation lomboks
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

//importation des classes
import com.uasz.DAOS_Microservice_Maquette.*;
import com.uasz.DAOS_Microservice_Maquette.models.Niveau;
import com.uasz.DAOS_Microservice_Maquette.repositories.NiveauRepository;

@AllArgsConstructor
@Service
@Transactional
public class NiveauService {
    @Autowired
    private NiveauRepository nRepository;

    public void ajouterNiveau(Niveau n){
        n.setDateCreationNiveau(new Date(System.currentTimeMillis()));
        nRepository.save(n);
    }

    public List<Niveau> rechercherNiveaux(){
        return nRepository.findAll();
    }

    public Niveau rechercherUnNiveau(Long idNiveau){
        return nRepository.findById(idNiveau).get();
    }

    public Niveau modifierNiveau(Niveau newNiveau){
        Niveau niveau = rechercherUnNiveau(newNiveau.getIdNiveau());
        niveau.setLibelleNiveau(newNiveau.getLibelleNiveau());
        niveau.setDescriptionNiveau(newNiveau.getDescriptionNiveau());
        return nRepository.save(niveau);
    }

    public void supprimerNiveau(Niveau n){
        nRepository.delete(n);
    }

    public Niveau ajouter_niveau(Niveau n){
        n.setDateCreationNiveau(new Date(System.currentTimeMillis()));
        return nRepository.save(n);
    }

    public Niveau modifier_niveau(Niveau n, Long id){
        n.setIdNiveau(id);
        return nRepository.save(n);
    }

    public void supprimer_niveau(Long id){
        nRepository.deleteById(id);
    }
}
