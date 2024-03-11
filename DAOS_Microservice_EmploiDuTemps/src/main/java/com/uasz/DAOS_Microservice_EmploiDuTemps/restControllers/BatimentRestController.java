package com.uasz.DAOS_Microservice_EmploiDuTemps.restControllers;

import org.springframework.web.bind.annotation.RestController;

import com.uasz.DAOS_Microservice_EmploiDuTemps.models.Batiment;
import com.uasz.DAOS_Microservice_EmploiDuTemps.models.Salle;
import com.uasz.DAOS_Microservice_EmploiDuTemps.services.BatimentService;

import java.util.List;

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
import org.springframework.web.bind.annotation.ResponseStatus;;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/emploi/api/batiment")
public class BatimentRestController {
    @Autowired
    private BatimentService batimentService;

    @GetMapping 
    public List<Batiment> lister_batiment(){
        return batimentService.listerToutBatiment();
    }

    @GetMapping(path = "/{id}")
    public Batiment recherche_Batiment(@PathVariable Long id){
        return batimentService.recherche_Batiment(id);
    }
    
    @PostMapping
    public Batiment ajouter_Batiment(@RequestBody Batiment batiment){
        return batimentService.ajouter_Batiment(batiment);
    }

    @PutMapping(path = "/{id}")
    public Batiment modifier_Batiment(@RequestBody Batiment batiment, @PathVariable Long id){
        return batimentService.modifier_Batiment(batiment,id);
    }

    @DeleteMapping(path = "/{id}")
    public void supprimer_Batiment(@PathVariable Long id){
        batimentService.supprimer_Batiment(id);
    }

    @PostMapping(path ="/{id}/salles")
    @ResponseStatus(HttpStatus.OK)
    public Salle ajouterSalleDansBatiment (@PathVariable("id") Long id, @RequestBody Salle s) {
        Batiment b = batimentService.recherche_Batiment(id);
        batimentService.ajouterSalleDansBatiment(s, b);
        return s;
    }

    @GetMapping("/{id}/salles")
    public List<Salle> afficherLesSalles(@PathVariable("id") Long id) {
       return batimentService.afficherLesSalles(id);
    }
    
}
