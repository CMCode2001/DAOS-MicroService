package com.uasz.DAOS_Microservice_Repartition.restControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uasz.DAOS_Microservice_Repartition.models.Enseignant;
import com.uasz.DAOS_Microservice_Repartition.models.Enseignement;
import com.uasz.DAOS_Microservice_Repartition.models.Repartition;
import com.uasz.DAOS_Microservice_Repartition.repositories.EnseignantRepository;
import com.uasz.DAOS_Microservice_Repartition.repositories.EnseignementRepository;
import com.uasz.DAOS_Microservice_Repartition.repositories.RepartitionRepository;
import com.uasz.DAOS_Microservice_Repartition.services.RepartitionService;




@CrossOrigin(origins = "*", allowedHeaders="*")
@RestController
@RequestMapping(path = "/repartition/api/repartition")
public class RepartitionRestController {

    
    @Autowired
    private RepartitionService rService;

    @Autowired
    private EnseignementRepository eRepository;

    @Autowired
    private EnseignantRepository enseignantRepository;

    // @Autowired
    // private SeanceRepository sRepository;

    @Autowired
    private RepartitionRepository repository;

    @GetMapping
    private List<Repartition> lister_repartition(){
        return rService.listerToutRepartition();
    }

    @GetMapping(path = "/{id}")
    private Repartition rechercher_repartition(@PathVariable Long id){
        return rService.rechercherRepartition(id);
    }

    @PostMapping
    public Repartition ajouter_repartition(@RequestBody Repartition c){
        return rService.ajouter_repartition(c);
    }



    @PutMapping(path = "/{id}")
    public Repartition modifier_repartition(@PathVariable Long id, @RequestBody Repartition c){
        return rService.modifier_repartition(c, id);
    }

    @DeleteMapping(path = "/{id}")
    public void supprimer_repartition(@PathVariable Long id){
        rService.supprimer_repartition(id);
    }


    @PutMapping(path = "{id}/enseignements/{idEnseignement}")
    public Repartition assigner_Enseignement(@PathVariable Long id,@PathVariable Long idEnseignement){
        Enseignement e = eRepository.findById(idEnseignement).get();
        Repartition r = rService.rechercherRepartition(id);
        r.setEnseignement(e);
        eRepository.save(e);
        return repository.save(r);
    }

    @GetMapping(path = "{id}/enseignements")
    public Enseignement assigner_Enseignement(@PathVariable Long id){
        return rService.afficherEnseignements(id);
    }

    @PutMapping(path = "{id}/enseignants/{idEnseignant}")
    public Repartition assigner_Enseignant(@PathVariable Long id,@PathVariable Long idEnseignant){
        Enseignant e = enseignantRepository.findById(idEnseignant).get();
        Repartition r = rService.rechercherRepartition(id);
        r.setEnseignant(e);
        enseignantRepository.save(e);
        return repository.save(r);
    }

    // @PutMapping(path = "{id}/seances/{idSeance}")
    // public Repartition assigner_Seance(@PathVariable Long id,@PathVariable Long idSeance){
    //     Seance s = sRepository.findById(idSeance).get();
    //     Repartition r = rService.rechercherRepartition(id);
    //     s.setRepartition(r);
    //     sRepository.save(s);
    //     return repository.save(r);
    // }

    // @GetMapping(path = "{id}/seances")
    // public List<Seance> afficherSeances(Long id){
    //     return  rService.afficherSeances(id);
    // }


    
}
