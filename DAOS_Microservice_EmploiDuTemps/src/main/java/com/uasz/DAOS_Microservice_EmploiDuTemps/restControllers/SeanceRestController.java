package com.uasz.DAOS_Microservice_EmploiDuTemps.restControllers;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.uasz.DAOS_Microservice_EmploiDuTemps.models.Deroulement;
import com.uasz.DAOS_Microservice_EmploiDuTemps.models.Repartition;
import com.uasz.DAOS_Microservice_EmploiDuTemps.models.Salle;
import com.uasz.DAOS_Microservice_EmploiDuTemps.models.Seance;
import com.uasz.DAOS_Microservice_EmploiDuTemps.repositories.RepartitionRepository;
import com.uasz.DAOS_Microservice_EmploiDuTemps.repositories.SalleRepository;
import com.uasz.DAOS_Microservice_EmploiDuTemps.repositories.SeanceRepository;
import com.uasz.DAOS_Microservice_EmploiDuTemps.services.SeanceService;
import org.springframework.web.bind.annotation.RequestParam;




@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/emploi/api/seance")
public class SeanceRestController {
     @Autowired
    private SeanceService seanceService;

    @Autowired 
    private SalleRepository sRepository;

    @Autowired
    private SeanceRepository seanceRepository;

    @Autowired
    private RepartitionRepository repartitionRepository;

    @Autowired
    private SeanceRepository sRepository2;

    //GET
    @GetMapping 
    public List<Seance> lister_Seance(){
        return seanceService.listerToutSeance();
    }

    @GetMapping(path = "/{id}")
    public Seance recherche_Seance(@PathVariable Long id){
        return seanceService.recherche_Seance(id);
    }

    //POST
    @PostMapping
    public Seance ajouter_Seance(@RequestBody Seance seance){
        seance.setDateCreationSeance(new Date(System.currentTimeMillis()));
        return seanceService.ajouter_Seance(seance);
    }


    //PUT
     @PutMapping(path = "/{id}")
    public Seance modifier_Seance(@RequestBody Seance seance, @PathVariable Long id){
        return seanceService.modifier_Seance(seance,id);
    }


    //DELETE
     @DeleteMapping(path = "/{id}")
    public void supprimer_Seance(@PathVariable Long id){
        seanceService.supprimer_Seance(id);
    }

    @PutMapping(path = "{id}/salles/{idSalle}")
    public Seance ajouter_Salle_Seance(@PathVariable Long id,@PathVariable Long idSalle){
        Salle s = sRepository.findById(idSalle).get();
        Seance se = seanceService.recherche_Seance(id);
        se.setSalle(s);
       sRepository.save(s);

        return seanceRepository.save(se);
       
    }

    @GetMapping(path = "{id}/salles")
    public Salle salleAssigner(@PathVariable Long id){
        return seanceService.salle_assigner(id);
    }


    
    @PostMapping("/{id}/deroulement")
    @ResponseStatus(HttpStatus.OK)
    public Deroulement ajouterDeroulement (@PathVariable("id") Long id, @RequestBody Deroulement d) {
        Seance s = seanceService.recherche_Seance(id);
        seanceService.ajouter_Deroulement(d, s);
        return d;
    }
    @GetMapping("/{id}/deroulement")
    public Deroulement getDeroulementBySeanceId(@PathVariable Long id) {
        Seance seance = seanceService.recherche_Seance(id);
        return seance.getDeroulement();
    }

    @PutMapping(path = "{id}/repartitions/{idRepartition}")
    public Seance assigner_Repartition(@PathVariable Long id,@PathVariable Long idRepartition){
        Repartition e = repartitionRepository.findById(idRepartition).get();
        Seance r = recherche_Seance(id);
        r.setRepartition(e);
        e.getSeances().add(r);
        repartitionRepository.save(e);
        return sRepository2.save(r);
    }


    @GetMapping(path = "{id}/repartitions")
    public Repartition afficherRepartitions(@PathVariable Long id) {
        return seanceService.afficherRepartitions(id);
    }
    
    @GetMapping(path = "repartition/{id}/seances")
    public List<Seance> SeanceAssigner(@PathVariable Long id) {
        Repartition r = repartitionRepository.findById(id).get();
        return r.getSeances();
    }
    
}

