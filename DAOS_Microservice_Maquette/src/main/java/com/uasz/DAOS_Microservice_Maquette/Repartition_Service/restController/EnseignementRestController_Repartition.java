package com.uasz.DAOS_Microservice_Maquette.Repartition_Service.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uasz.DAOS_Microservice_Maquette.Repartition_Service.model.Enseignement_Repartition;
import com.uasz.DAOS_Microservice_Maquette.Repartition_Service.services.EnseignementService_Repartition;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/maquette/api")
public class EnseignementRestController_Repartition {

    @Autowired
    private EnseignementService_Repartition enseignementService_repartition;

    @GetMapping(path = "/enseignements_Repartitions")
    public List<Enseignement_Repartition> lister_Enseignement(){
        return enseignementService_repartition.lister_Enseignement_Repartition();
    }

}