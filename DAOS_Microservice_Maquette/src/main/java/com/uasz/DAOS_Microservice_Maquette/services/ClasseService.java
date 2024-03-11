package com.uasz.DAOS_Microservice_Maquette.services;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//importation Lomboks
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

//importation des classes
import com.uasz.DAOS_Microservice_Maquette.models.Classe;
import com.uasz.DAOS_Microservice_Maquette.models.Enseignement;
import com.uasz.DAOS_Microservice_Maquette.models.Groupe;
import com.uasz.DAOS_Microservice_Maquette.repositories.ClasseRepository;

@Service
@Transactional
@AllArgsConstructor
public class ClasseService {
     @Autowired
    private ClasseRepository cRepository;

    @Autowired
    private GroupeService gService;

    public void ajouterClasse(Classe c) {
        c.setDateCreationClasse(new Date(System.currentTimeMillis()));
        cRepository.save(c);
    }

    public List<Classe> rechercherLesClasses(){
        return cRepository.findAll();
    }

    public Classe rechercherUneClasse(Long idClasse){ 
        return cRepository.findById(idClasse).get();
    }

    public Classe modifierClasse(Classe classe){
        Classe cModifier = rechercherUneClasse(classe.getIdClasse());
        cModifier.setLibelleClasse(classe.getLibelleClasse());
        cModifier.setEffectifClasse(classe.getEffectifClasse());
        cModifier.setNbreGroupeClasse(classe.getNbreGroupeClasse());
        cModifier.setDescriptionClasse(classe.getDescriptionClasse());
        return cRepository.save(cModifier);
    }

    public void supprimerClasse(Classe c){
        cRepository.delete(c);
    }

    public Classe ajouter_classe(Classe c){
        c.setDateCreationClasse(new Date(System.currentTimeMillis()));
        return cRepository.save(c);
    }
    
    public Classe modifier_classe(Long id, Classe c){
        c.setIdClasse(id);
        return cRepository.save(c);
    }

    public void supprimer_classe(Long id){
        cRepository.deleteById(id);
    }

    public List<Groupe> afficherGroupes(Long id){
        Classe c = rechercherUneClasse(id);
        return c.getGroupes();
    }

    public List<Enseignement> afficherEnseignements(Long id){
        Classe c = rechercherUneClasse(id);
        return c.getEnseignements();
    }

    public void ajouterGroupeDansClasse(Classe c, Groupe g) {
        c.getGroupes().add(g);
        g.setClasse(c); 
        gService.ajouterGroupe(g);
    }
    
}
