package com.uasz.DAOS_Microservice_Maquette.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//importation Lomboks
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

//importation des classes
import com.uasz.DAOS_Microservice_Maquette.models.Filiere;
import com.uasz.DAOS_Microservice_Maquette.models.Formation;
import com.uasz.DAOS_Microservice_Maquette.repositories.FiliereRepository;

@Service
@Transactional
@AllArgsConstructor
public class FiliereService {
       @Autowired
    private FiliereRepository fRepository;

    public void ajouterFiliere(Filiere f){
        f.setDateCreationFiliere(new Date(System.currentTimeMillis()));
        fRepository.save(f);
    }

    public List<Filiere> rechercherFilieres(){
        return fRepository.findAll();
    }

    public Filiere rechercherUneFiliere(Long idFil){
        return fRepository.findById(idFil).get();
    }

    public Filiere modifierFiliere(Filiere newFiliere){
        Filiere f = rechercherUneFiliere(newFiliere.getIdFiliere());
        f.setLibelleFiliere(newFiliere.getLibelleFiliere());
        f.setDescriptionFiliere(newFiliere.getDescriptionFiliere());
        return fRepository.save(f);
    }

    public void supprimerFiliere(Filiere f){
        fRepository.delete(f);
    }
    
    public Filiere ajouter_filiere( Filiere f){
        f.setDateCreationFiliere(new Date(System.currentTimeMillis()));
        return fRepository.save(f);
    }

    public Filiere modifier_filiere(Filiere f, Long id){
        f.setIdFiliere(id);
        return fRepository.save(f);
    }

    public void supprimer_filiere(Long id){
        fRepository.deleteById(id);
    }

    public List<Formation> afficheFormations(Long id){
        Filiere f = rechercherUneFiliere(id);
        return f.getFormations();
    }


}