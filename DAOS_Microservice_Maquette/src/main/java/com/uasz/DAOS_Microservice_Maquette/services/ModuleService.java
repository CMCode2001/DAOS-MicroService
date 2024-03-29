package com.uasz.DAOS_Microservice_Maquette.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//importation Lomboks
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

import com.uasz.DAOS_Microservice_Maquette.models.Enseignement;
//importation des classes
import com.uasz.DAOS_Microservice_Maquette.models.Module;
import com.uasz.DAOS_Microservice_Maquette.repositories.ModuleRepository;

@Service
@Transactional
@AllArgsConstructor
public class ModuleService {
    @Autowired
    private ModuleRepository mRepository;

    public void ajouterModule(Module m){
        m.setDateCreationModule(new Date(System.currentTimeMillis()));
        mRepository.save(m);
    }

    public List<Module> rechercherModules(){
        return mRepository.findAll();
    }

    public Module rechercherUnModule(Long idMod){
        return mRepository.findById(idMod).get();
    }

    public Module modifierModule(Module newModule){
        Module m = rechercherUnModule(newModule.getIdModule());
        m.setLibelleModule(newModule.getLibelleModule());
        m.setCoursModule(newModule.getCoursModule());
        m.setDureeModule(newModule.getDureeModule());
        m.setObjectifsModule(newModule.getObjectifsModule());
        m.setDescriptionModule(newModule.getDescriptionModule());
        return mRepository.save(m);
    }

    public void supprimerModule(Module m){
        mRepository.delete(m);
    }

    public Module ajouter_module(Module m){
        m.setDateCreationModule(new Date(System.currentTimeMillis()));
        return mRepository.save(m);
    }

    public Module modifier_module(Module m, Long id){
        m.setIdModule(id);
        return mRepository.save(m);
    }

    public void supprimer_module(Long id){
        mRepository.deleteById(id);
    }



    public List<Enseignement> afficherEnseignements(Long id){
        Module m = rechercherUnModule(id);
        return m.getEnseignements();
        
    }
}
