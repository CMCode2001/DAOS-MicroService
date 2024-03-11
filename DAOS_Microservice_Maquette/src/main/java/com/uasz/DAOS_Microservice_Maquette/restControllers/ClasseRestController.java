package com.uasz.DAOS_Microservice_Maquette.restControllers;

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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.uasz.DAOS_Microservice_Maquette.models.Classe;
import com.uasz.DAOS_Microservice_Maquette.models.Enseignement;
import com.uasz.DAOS_Microservice_Maquette.models.Groupe;
import com.uasz.DAOS_Microservice_Maquette.repositories.ClasseRepository;
import com.uasz.DAOS_Microservice_Maquette.repositories.EnseignementRepository;
import com.uasz.DAOS_Microservice_Maquette.services.ClasseService;

@CrossOrigin(origins = "*", allowedHeaders="*")
@RestController
@RequestMapping(path = "/maquette/api/classe")
public class ClasseRestController {
    @Autowired
    private ClasseService classeService;

    @Autowired
    private EnseignementRepository eRepository;

    @Autowired
    private ClasseRepository classeRepository;

    @GetMapping
    private List<Classe> lister_classe(){
        return classeService.rechercherLesClasses();
    }

    @GetMapping(path = "/{id}")
    private Classe rechercher_classe(@PathVariable Long id){
        return classeService.rechercherUneClasse(id);
    }

    @PostMapping
    public Classe ajouter_classe(@RequestBody Classe c){
        return classeService.ajouter_classe(c);
    }

    @PutMapping(path = "/{id}")
    public Classe modifier_classe(@PathVariable Long id, @RequestBody Classe c){
        return classeService.modifier_classe(id, c);
    }

    @DeleteMapping(path = "/{id}")
    public void supprimer_classe(@PathVariable Long id){
        classeService.supprimer_classe(id);
    }

    @PostMapping("/{id}/groupes")
    @ResponseStatus(HttpStatus.OK)
    public Groupe ajouterGroupeDansClasse(@PathVariable("id") Long id, @RequestBody Groupe g) {
        Classe c = classeService.rechercherUneClasse(id);
        classeService.ajouterGroupeDansClasse(c, g);
        return g;
    }

    @GetMapping("/{id}/groupes")
    public List<Groupe> afficherLesGroupes(@PathVariable("id") Long id) {
       return classeService.afficherGroupes(id);
    }

    @GetMapping("/{id}/enseignements")
    public List<Enseignement> afficherLesEnseignements(@PathVariable("id") Long id) {
       return classeService.afficherEnseignements(id);
    }

    @PutMapping(path = "{id}/enseignements/{idEnseignement}")
    public Classe assigner_Enseignement(@PathVariable Long id,@PathVariable Long idEnseignement){
        Enseignement e = eRepository.findById(idEnseignement).get();
        Classe c = classeService.rechercherUneClasse(id);;
        e.setClasse(c);
        eRepository.save(e);
        return classeRepository.save(c);
    }
}
