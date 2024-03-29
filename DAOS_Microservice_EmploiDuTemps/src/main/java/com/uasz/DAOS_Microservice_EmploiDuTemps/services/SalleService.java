package com.uasz.DAOS_Microservice_EmploiDuTemps.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uasz.DAOS_Microservice_EmploiDuTemps.models.Salle;
import com.uasz.DAOS_Microservice_EmploiDuTemps.models.Seance;
import com.uasz.DAOS_Microservice_EmploiDuTemps.repositories.SalleRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class SalleService {
    @Autowired
    private SalleRepository salleRepository;

    @Autowired SeanceService seanceService;

    //AJOUTER 
    public Salle ajouter_Salle(Salle salle){
        Salle savedSalle = salleRepository.save(salle);
        savedSalle.setDateCreationSalle(new Date(System.currentTimeMillis()));
        return salleRepository.save(savedSalle);
    }

    //MODIFIER
    public Salle modifier_Salle(Salle salle, Long idSalle){
        salle.setIdSalle(idSalle);
        return salleRepository.save(salle);
    }

    //RECHERCHER
    public Salle recherche_Salle(Long idSalle) {
      return salleRepository.findById(idSalle).get();
    }
    //SUPPRIMER
    public void supprimer_Salle(Long idSalle){
        salleRepository.deleteById(idSalle);
    }

    //LISTER TOUT ATTRIBUT
    public List<Salle> listerToutSalle() {
       return salleRepository.findAll();
    }

    public void ajouterSeanceDansSalle(Salle s, Seance b) {
        s.getSeances().add(b);
        b.setSalle(s);
        seanceService.ajouter_Seance(b);
    }

    public List<Seance> afficherLesSeances(Long id){
        Salle b =  recherche_Salle(id);
        return b.getSeances();
    }

    
}
