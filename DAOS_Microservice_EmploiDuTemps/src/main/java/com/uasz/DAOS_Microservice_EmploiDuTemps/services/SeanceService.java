package com.uasz.DAOS_Microservice_EmploiDuTemps.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uasz.DAOS_Microservice_EmploiDuTemps.models.Deroulement;
import com.uasz.DAOS_Microservice_EmploiDuTemps.models.Repartition;
import com.uasz.DAOS_Microservice_EmploiDuTemps.models.Salle;
import com.uasz.DAOS_Microservice_EmploiDuTemps.models.Seance;
import com.uasz.DAOS_Microservice_EmploiDuTemps.repositories.SeanceRepository;

import jakarta.transaction.Transactional;
import lombok.Data;

@Service
@Transactional
@Data
public class SeanceService {
     @Autowired
    private SeanceRepository seanceRepository ;

    @Autowired
    private DeroulementService dService;

    //AJOUTER 
    public Seance ajouter_Seance(Seance seance){
        Seance savedSeance = seanceRepository.save(seance);
        savedSeance.setDateCreationSeance(new Date(System.currentTimeMillis()));
        return seanceRepository.save(savedSeance);
    }

    //MODIFIER
    public Seance modifier_Seance(Seance seance, Long idSeance){
        seance.setIdSeance(idSeance);
        return seanceRepository.save(seance);
    }

    //RECHERCHER
    public Seance recherche_Seance(Long idSeance) {
      return seanceRepository.findById(idSeance).get();
    }
    //SUPPRIMER
    public void supprimer_Seance(Long id){
        seanceRepository.deleteById(id);
    }

    //LISTER TOUT ATTRIBUT
    public List<Seance> listerToutSeance() {
       return seanceRepository.findAll();
    }

    public Seance updatSeance(Seance s){
        return seanceRepository.save(s);
    }

    public Salle salle_assigner(Long id){
        Seance s = recherche_Seance(id);
        return s.getSalle();
    }

    public void ajouter_Deroulement(Deroulement d, Seance s){
        s.setDeroulement(d);
        d.setSeance(s);
        dService.ajouter_Deroulement(d);
        seanceRepository.save(s);
    }
    public Repartition afficherRepartitions(Long id) {
        Seance r = recherche_Seance(id);
        return r.getRepartition();
    
    }
}
