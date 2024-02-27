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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.uasz.DAOS_Microservice_Maquette.models.UE;
import com.uasz.DAOS_Microservice_Maquette.services.UEService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/maquette/api/ue")
public class UERestController {
    @Autowired
    private UEService ueService;

    @GetMapping 
    @ResponseStatus(HttpStatus.OK)
    public List<UE> lister_ue(){
        return ueService.listerToutUE();
    }

    @GetMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UE recherche_UE(@PathVariable Long id){
        return ueService.rechercherUE(id);
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UE ajouter_ue(@RequestBody UE ue){
        return ueService.ajouter_UE(ue);
    }

    @PutMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UE modifier_ue(@RequestBody UE ue, @PathVariable Long id){
        return ueService.modifier_UE(ue, id);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void supprimer_ue(@PathVariable Long id){
        ueService.supprimer_UE(id);
    }
}
