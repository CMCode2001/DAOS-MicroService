package com.uasz.DAOS_Microservice_Maquette.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

//importation des classes
import com.uasz.DAOS_Microservice_Maquette.*;
import com.uasz.DAOS_Microservice_Maquette.models.Semestre;
import com.uasz.DAOS_Microservice_Maquette.repositories.SemestreRepository;

@Service
@Transactional
@AllArgsConstructor
public class SemestreService {
    @Autowired
    private SemestreRepository sRepository;

    public void ajouterSemestre(Semestre s){
        s.setDateCreationSemestre(new Date(System.currentTimeMillis()));
        sRepository.save(s);
    }

    public List<Semestre> rechercherSemestres(){
        return sRepository.findAll();
    }

    public Semestre rechercherUneSemestre(Long idSemestre){
        return sRepository.findById(idSemestre).get();
    }

    public Semestre modifierSemestre(Semestre newSemestre){
        Semestre semestre = rechercherUneSemestre(newSemestre.getIdSemestre());
        semestre.setLibelleSemestre(newSemestre.getLibelleSemestre());
        semestre.setDescriptionSemestre(newSemestre.getDescriptionSemestre());
        return sRepository.save(semestre);
    }

    public void supprimerSemestre(Semestre s){
        sRepository.delete(s);
    }

    public Semestre ajouter_semestre(Semestre s){
        s.setDateCreationSemestre(new Date(System.currentTimeMillis()));
        return sRepository.save(s);
    }

    public Semestre modifier_semestre(Long id, Semestre s){
        s.setIdSemestre(id);
        return sRepository.save(s);
    }

    public void supprimer_semestre( Long id){
        sRepository.deleteById(id);
    }
}