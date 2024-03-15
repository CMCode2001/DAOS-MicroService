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

import com.uasz.DAOS_Microservice_Maquette.models.Classe;
import com.uasz.DAOS_Microservice_Maquette.models.Module;
import com.uasz.DAOS_Microservice_Maquette.models.Semestre;
import com.uasz.DAOS_Microservice_Maquette.repositories.ClasseRepository;
import com.uasz.DAOS_Microservice_Maquette.repositories.ModuleRepository;
import com.uasz.DAOS_Microservice_Maquette.repositories.SemestreRepository;
import com.uasz.DAOS_Microservice_Maquette.services.SemestreService;;

// @CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(path = "/maquette/api/semestre")
public class SemestreRestController {
       @Autowired
    private SemestreService semestreService;

    @Autowired
    private ClasseRepository cRepository;
    
    @Autowired
    private ModuleRepository mRepository;

    @Autowired 
    private SemestreRepository sRepository;

    @GetMapping
    public List<Semestre> lister_semestre(){
        return semestreService.rechercherSemestres();
    }

    @GetMapping(path = "/{id}")
    public Semestre rechercher_semestre(@PathVariable Long id){
        return semestreService.rechercherUneSemestre(id);
    }

    @PostMapping
    public Semestre ajouter_semestre(@RequestBody Semestre s){
        return semestreService.ajouter_semestre(s);
    }

    @PutMapping(path = "/{id}")
    public Semestre modifier_Semestre(@PathVariable Long id, @RequestBody Semestre s){
        return semestreService.modifier_semestre(id, s);
    }

    @DeleteMapping(path = "/{id}")
    public void supprimer_semestre(@PathVariable Long id){
        semestreService.supprimer_semestre(id);
    }

    @PutMapping(path = "{id}/classes/{idClasse}")
    public Semestre assigner_Classe(@PathVariable Long id,@PathVariable Long idClasse){
        Classe c = cRepository.findById(idClasse).get();
        Semestre s = semestreService.rechercherUneSemestre(id);
        c.setSemestre(s);
        cRepository.save(c);
        return sRepository.save(s);
    }

    @PutMapping(path = "{id}/modules/{idModule}")
    public Semestre assigner_Module(@PathVariable Long id,@PathVariable Long idModule){
        Module m = mRepository.findById(idModule).get();
        Semestre s = semestreService.rechercherUneSemestre(id);
        m.setSemestre(s);
        mRepository.save(m);
        return sRepository.save(s);
    }

    @GetMapping(path = "{id}/classes")
    public List<Classe> afficherClasses(@PathVariable Long id){
        return semestreService.afficherClasses(id);
    }

    @GetMapping(path = "{id}/modules")
    public List<Module> afficherModules(@PathVariable Long id){
        return semestreService.afficherModules(id);
    }
}
