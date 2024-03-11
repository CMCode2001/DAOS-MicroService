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

import com.uasz.DAOS_Microservice_Maquette.models.Enseignement;
import com.uasz.DAOS_Microservice_Maquette.models.Module;
import com.uasz.DAOS_Microservice_Maquette.repositories.EnseignementRepository;
import com.uasz.DAOS_Microservice_Maquette.repositories.ModuleRepository;
import com.uasz.DAOS_Microservice_Maquette.services.ModuleService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(path = "/maquette/api/module")
public class ModuleRestController {
        @Autowired
    private ModuleService moduleService;
 
    @Autowired
    private EnseignementRepository eRepository;

    @Autowired
    private ModuleRepository moduleRepository;


    @GetMapping
    public List<Module> lister_module(){
        return moduleService.rechercherModules();
    }

    @GetMapping(path = "/{id}")
    public Module recherche_module(@PathVariable Long id){
        return moduleService.rechercherUnModule(id);
    }

    @PostMapping
    public Module ajouter_module(@RequestBody Module m){
        return moduleService.ajouter_module(m);
    }

    @PutMapping(path = "/{id}")
    public Module modifier_module(@RequestBody Module m, @PathVariable Long id){
        return moduleService.modifier_module(m, id);
    }

    @DeleteMapping(path = "/{id}")
    public void supprimer_module(@PathVariable Long id){
        moduleService.supprimer_module(id);
    }
    
     @PutMapping(path = "{id}/enseignements/{idEnseignement}")
    public Module assigner_Enseignement(@PathVariable Long id,@PathVariable Long idEnseignement){
        Enseignement e = eRepository.findById(idEnseignement).get();
        Module m = moduleService.rechercherUnModule(id);
        e.setModule(m);
        eRepository.save(e);
        return moduleRepository.save(m);
    }

    @GetMapping("/{id}/enseignements")
    public List<Enseignement> afficherLesEnseignements(@PathVariable("id") Long id) {
       return moduleService.afficherEnseignements(id);
    }
}
