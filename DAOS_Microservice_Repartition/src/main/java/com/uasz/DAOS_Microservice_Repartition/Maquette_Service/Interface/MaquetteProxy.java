package com.uasz.DAOS_Microservice_Repartition.Maquette_Service.Interface;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.uasz.DAOS_Microservice_Repartition.models.Enseignement;

@FeignClient(name = "maquette-service", url = "localhost:8080")
public interface MaquetteProxy {

    @GetMapping(path = "/maquette/api/enseignements_Repartitions")
    public List<Enseignement> lister_Enseignement();


    
}
