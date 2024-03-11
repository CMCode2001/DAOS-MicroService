package com.uasz.DAOS_Microservice_Repartition.restControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uasz.DAOS_Microservice_Repartition.models.Repartition;
import com.uasz.DAOS_Microservice_Repartition.services.EnseignementService;

@CrossOrigin(origins = "*", allowedHeaders="*")
@RestController
@RequestMapping(path = "/maquette/api/enseignement")
public class EnseignementRestController {

    @Autowired
    private EnseignementService eService;
    

    @GetMapping("/{id}/repartitions")
    public List<Repartition> afficherLesRepartitions(@PathVariable("id") Long id) {
       return eService.afficherRepartitions(id);
    }
}
