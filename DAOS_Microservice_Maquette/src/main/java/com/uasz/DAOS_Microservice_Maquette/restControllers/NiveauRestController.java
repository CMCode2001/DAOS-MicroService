package com.uasz.DAOS_Microservice_Maquette.restControllers;

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

import com.uasz.DAOS_Microservice_Maquette.models.Cycle;
import com.uasz.DAOS_Microservice_Maquette.models.Formation;
import com.uasz.DAOS_Microservice_Maquette.models.Niveau;
import com.uasz.DAOS_Microservice_Maquette.repositories.FormationRepository;
import com.uasz.DAOS_Microservice_Maquette.repositories.NiveauRepository;
import com.uasz.DAOS_Microservice_Maquette.services.NiveauService;



// @CrossOrigin(origins = "*", allowedHeaders="*")
@RestController
@RequestMapping(path = "/maquette/api/niveau")
public class NiveauRestController {
       @Autowired
    private NiveauService niveauService;

    @Autowired
    private FormationRepository fRepository;
    
    @Autowired
    private NiveauRepository nRepository;

    @GetMapping
    private List<Niveau> lister_niveau(){
        return niveauService.rechercherNiveaux();
    }

    @GetMapping(path = "/{id}")
    private Niveau rechercher_niveau(@PathVariable Long id){
        return niveauService.rechercherUnNiveau(id);
    }

    @PostMapping
    public Niveau ajouter_niveau(@RequestBody Niveau c){
        return niveauService.ajouter_niveau(c);
    }

    @PutMapping(path = "/{id}")
    public Niveau modifier_niveau(@PathVariable Long id, @RequestBody Niveau c){
        return niveauService.modifier_niveau( c, id);
    }

    @DeleteMapping(path = "/{id}")
    public void supprimer_niveau(@PathVariable Long id){
        niveauService.supprimer_niveau(id);
    }

    @PutMapping(path = "{id}/formations/{idFormation}")
    public Niveau assignerFormations(@PathVariable Long id,@PathVariable Long idFormation){
        Formation f = fRepository.findById(idFormation).get();
        Niveau n = niveauService.rechercherUnNiveau(id);
        f.setNiveau(n);;
        fRepository.save(f);
        return nRepository.save(n);
    }

    @GetMapping(path = "{id}/formations")
    public List<Formation> afficherFormations(@PathVariable Long id) {
        return niveauService.afficherFormations(id);
    }
    
     @GetMapping(path = "/{id}/cycle")
    public Cycle afficherCycle(@PathVariable Long id){
        return niveauService.afficherCycle(id);
    }
}
