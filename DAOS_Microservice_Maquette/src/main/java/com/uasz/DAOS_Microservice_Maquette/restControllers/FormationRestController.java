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

import com.uasz.DAOS_Microservice_Maquette.models.Formation;
import com.uasz.DAOS_Microservice_Maquette.services.FormationService;


@CrossOrigin(origins = "*", allowedHeaders="*")
@RestController
@RequestMapping(path = "/maquette/api/formation")
public class FormationRestController {
    @Autowired
    private FormationService formationService;

    @GetMapping
    private List<Formation> lister_formation(){
        return formationService.rechercherFormations();
    }

    @GetMapping(path = "/{id}")
    private Formation rechercher_formation(@PathVariable Long id){
        return formationService.rechercherUneFormation(id);
    }

    @PostMapping
    public Formation ajouter_formation(@RequestBody Formation c){
        return formationService.ajouter_formation(c);
    }

    @PutMapping(path = "/{id}")
    public Formation modifier_formation(@PathVariable Long id, @RequestBody Formation c){
        return formationService.modifier_formation( c, id);
    }

    @DeleteMapping(path = "/{id}")
    public void supprimer_formation(@PathVariable Long id){
        formationService.supprimer_formation(id);
    }
}
