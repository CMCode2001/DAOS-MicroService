package com.uasz.DAOS_Microservice_EmploiDuTemps.restControllers;

import org.springframework.web.bind.annotation.RestController;

import com.uasz.DAOS_Microservice_EmploiDuTemps.models.Emploi;
import com.uasz.DAOS_Microservice_EmploiDuTemps.models.Seance;
import com.uasz.DAOS_Microservice_EmploiDuTemps.repositories.EmploiRepository;
import com.uasz.DAOS_Microservice_EmploiDuTemps.repositories.SeanceRepository;
import com.uasz.DAOS_Microservice_EmploiDuTemps.services.EmploiService;

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


/**
 * EmploiRestController
 */
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(path = "/emploi/api/emploi-du-temps")
public class EmploiRestController {
    @Autowired
    private EmploiService service;

    @Autowired
    private SeanceRepository sRepository;

    @Autowired
    private EmploiRepository eRepository;

    //GET
    @GetMapping 
    public List<Emploi> lister_emploi(){
        return service.listerToutEmploi();
    }

    @GetMapping(path = "/{id}")
    public Emploi recherche_emploi(@PathVariable Long id){
        return service.recherche_emploi(id);
    }

    //POST
    @PostMapping
    public Emploi ajouter_emploi(@RequestBody Emploi e){
        return service.ajouter_emploi(e);
    }


    //PUT
     @PutMapping(path = "/{id}")
    public Emploi modifier_emploi(@RequestBody Emploi e, @PathVariable Long idBat){
        return service.modifier_emploi(e,idBat);
    }


    //DELETE
     @DeleteMapping(path = "/{id}")
    public void supprimer_emploi(@PathVariable Long id){
        service.supprimer_emploi(id);
    }
    
    @PutMapping(path = "{id}/seances/{idSeance}")
    public Emploi assigner_Seance(@PathVariable Long id,@PathVariable Long idSeance){
        Seance s = sRepository.findById(idSeance).get();
        Emploi e = service.recherche_emploi(id);
        s.setEmploi(e);;
        sRepository.save(s);
        return eRepository.save(e);
    }

    @GetMapping (path = "{id}/seances")
    public List<Seance> afficherSeances(@PathVariable Long id){
        return service.afficherSeances(id);
    }
    
}