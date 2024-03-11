package com.uasz.DAOS_Microservice_Maquette.restControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.uasz.DAOS_Microservice_Maquette.models.EC;
import com.uasz.DAOS_Microservice_Maquette.models.Module;
import com.uasz.DAOS_Microservice_Maquette.repositories.ECRepository;
import com.uasz.DAOS_Microservice_Maquette.repositories.ModuleRepository;
import com.uasz.DAOS_Microservice_Maquette.services.ECService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/maquette/api/ec")
public class ECRestController {
    @Autowired
    private ECService ecService;

    @Autowired
    private ModuleRepository moduleService;
    @Autowired
    private ECRepository repository;

    @GetMapping
    public List<EC> lister_ec(){
        return ecService.rechercherTousEC();
    } 

    @GetMapping(path = "/{id}")
    public EC recherche_ec(@PathVariable Long id){
        return ecService.rechercherEc(id);
    }

    @PostMapping
    public EC ajouter_ec(@RequestBody EC ec){
        return ecService.ajouter_ec(ec);
    }

    @PutMapping(path = "/{id}")
    public EC modifier_ec(@PathVariable Long id, @RequestBody EC ec){
        return ecService.modifier_ec(ec, id);
    }

    @DeleteMapping(path = "/{id}")
    public void supprimer_ec(@PathVariable Long id ){
        ecService.supprimer_ec(id);
    }

    @PostMapping("/{idEC}/modules")
    public ResponseEntity<EC> addModuleToEC(@PathVariable Long idEC, @RequestBody Module module) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ecService.addModuleToEC(idEC, module));
    }

    @GetMapping("/{idEC}/modules")
    public ResponseEntity<List<Module>> getModulesByEC(@PathVariable Long idEC) {
        return ResponseEntity.ok(ecService.getModulesByEC(idEC));
    }

    @PutMapping(path = "{id}/modules/{idModule}")
    public EC ajouter_Module_EC(@PathVariable Long id,@PathVariable Long idModule){
        Module m = moduleService.findById(idModule).get();
        EC ec = ecService.rechercherEc(id);
        m.setEc(ec);
        moduleService.save(m);

        return repository.save(ec);
    }
}

