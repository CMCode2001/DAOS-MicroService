package com.uasz.DAOS_Microservice_EmploiDuTemps.Repartition_Service.Interface;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.uasz.DAOS_Microservice_EmploiDuTemps.models.Repartition;

@FeignClient(name = "repartition-service", url = "localhost:8080")
public interface RepartitionProxy {

    @GetMapping(path = "/repartition/api/repartitions_emplois")
    public List<Repartition> lister_Repartitions();
    
}