package com.uasz.DAOS_Microservice_Repartition.Maquette_Service.Interface;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.uasz.DAOS_Microservice_Repartition.Maquette_Service.Model.UE;

@FeignClient(name = "maquette-service", url = "localhost:8081")
public interface UEProxy {

    @GetMapping(path = "/maquette/api/ue")
    public List<UE> lister_ue();

    @GetMapping(path = "/maquette/api/ue/{id}")
     public UE recherche_UE(@PathVariable Long id);
    
}
