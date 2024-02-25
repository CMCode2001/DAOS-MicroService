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

import com.uasz.DAOS_Microservice_Maquette.*;
import com.uasz.DAOS_Microservice_Maquette.models.Cycle;
import com.uasz.DAOS_Microservice_Maquette.services.CycleService;

@CrossOrigin(origins = "*", allowedHeaders="*")
@RestController
@RequestMapping(path = "/maquette/cycle")
public class CycleRestController {
    @Autowired
    private CycleService cService;

    @GetMapping
    private List<Cycle> lister_cycle(){
        return cService.rechercheTousCycles();
    }

    @GetMapping(path = "/{id}")
    private Cycle rechercher_cycle(@PathVariable Long id){
        return cService.rechercherUnCycle(id);
    }

    @PostMapping
    public Cycle ajouter_cycle(@RequestBody Cycle c){
        return cService.ajouter_cycle(c);
    }

    @PutMapping(path = "/{id}")
    public Cycle modifier_cycle(@PathVariable Long id, @RequestBody Cycle c){
        return cService.modifier_cycle(id, c);
    }

    @DeleteMapping(path = "/{id}")
    public void supprimer_cycle(@PathVariable Long id){
        cService.supprimer_cycle(id);
    }
}
