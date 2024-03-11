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

import com.uasz.DAOS_Microservice_Maquette.models.EC;
import com.uasz.DAOS_Microservice_Maquette.models.Module;
import com.uasz.DAOS_Microservice_Maquette.models.UE;
import com.uasz.DAOS_Microservice_Maquette.services.UEService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/maquette/api/ue")
public class UERestController {
    @Autowired
    private UEService ueService;

    @GetMapping 
    public List<UE> lister_ue(){
        return ueService.listerToutUE();
    }

    @GetMapping(path = "/{id}")
    public UE recherche_UE(@PathVariable Long id){
        return ueService.rechercherUE(id);
    }
    
    @PostMapping
    public UE ajouter_ue(@RequestBody UE ue){
        return ueService.ajouter_UE(ue);
    }

    @PutMapping(path = "/{id}")
    public UE modifier_ue(@RequestBody UE ue, @PathVariable Long id){
        return ueService.modifier_UE(ue, id);
    }

    @DeleteMapping(path = "/{id}")
    public void supprimer_ue(@PathVariable Long id){
        ueService.supprimer_UE(id);
    }

   /* @GetMapping(path = "/{id}/ecs")
    public List<EC> afficher_ue_ecs(UE ue) {
        return ueService.afficherLesECs(ue);
    }*/

    

    @PostMapping("/{id}/ecs")
    @ResponseStatus(HttpStatus.OK)
    public EC ajouterECdansUE(@PathVariable("id") Long id, @RequestBody EC ec) {
        UE ue = ueService.rechercherUE(id); 
        ueService.ajouterECdansUE(ec, ue);
        return ec;
    }

    @GetMapping("/{id}/ecs")
    public List<EC> afficherLesECs(@PathVariable("id") Long id) {
       return ueService.afficherLesECs(id);
    }

    @PostMapping("/{id}/modules")
    @ResponseStatus(HttpStatus.OK)
    public Module ajouterModuledansUE(@PathVariable("id") Long id, @RequestBody Module m) {
        UE ue = ueService.rechercherUE(id); 
        ueService.ajouterModuleDansUE(m, ue);
        return m;
    }

    @GetMapping("/{id}/modules")
    public List<Module> afficherLesModules(@PathVariable("id") Long id) {
       return ueService.afficherModules(id);
    }
   
}
