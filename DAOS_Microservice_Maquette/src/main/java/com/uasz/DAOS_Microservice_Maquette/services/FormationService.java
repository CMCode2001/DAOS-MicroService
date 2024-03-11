package com.uasz.DAOS_Microservice_Maquette.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//importation Lomboks
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

//importation des classes
import com.uasz.DAOS_Microservice_Maquette.*;
import com.uasz.DAOS_Microservice_Maquette.models.Classe;
import com.uasz.DAOS_Microservice_Maquette.models.Formation;
import com.uasz.DAOS_Microservice_Maquette.models.Maquette;
import com.uasz.DAOS_Microservice_Maquette.repositories.FormationRepository;

@Service
@Transactional
@AllArgsConstructor
public class FormationService {
    @Autowired
    private FormationRepository fRepository;

    public void ajouterFormation(Formation f){
        f.setDateCreationFormation(new Date(System.currentTimeMillis()));
        fRepository.save(f);
    }

    public List<Formation> rechercherFormations(){
        return fRepository.findAll();
    }

    public Formation rechercherUneFormation(Long idFil){
        return fRepository.findById(idFil).get();
    }

    public Formation modifierFormation(Formation newFormation){
        Formation f = rechercherUneFormation(newFormation.getIdFormation());
        f.setLibelleFormation(newFormation.getLibelleFormation());
        f.setDescriptionFormation(newFormation.getDescriptionFormation());
        return fRepository.save(f);
    }

    public void supprimerFormation(Formation f){
        fRepository.delete(f);
    }

    public Formation ajouter_formation( Formation f){
        f.setDateCreationFormation(new Date(System.currentTimeMillis()));
        return fRepository.save(f);
    }

    public Formation modifier_formation(Formation f, Long id){
        f.setIdFormation(id);
        return fRepository.save(f);
    }

    public void supprimer_formation(Long id){
        fRepository.deleteById(id);
    }

    public List<Classe> afficherClasses(Long id){
        Formation f = rechercherUneFormation(id);
        return f.getClasses();
    } 

    public Maquette afficherMaquette(Long id){
        Formation f = rechercherUneFormation(id);
        return f.getMaquette();
    } 
}
