package com.uasz.DAOS_Microservice_Repartition.EmploiDuTemps_Service.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uasz.DAOS_Microservice_Repartition.EmploiDuTemps_Service.Service.RepartitionService_Emploi;
import com.uasz.DAOS_Microservice_Repartition.EmploiDuTemps_Service.model.Repartition_Emploi;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/repartition/api")
public class RepartitionRestController_Emploi {
    @Autowired
    private RepartitionService_Emploi rService_Emploi;

    @GetMapping(path = "/repartitions_emplois")
    public List<Repartition_Emploi> lister_Repartitions(){
        return rService_Emploi.lister_Repartition_Emploi();
    }
}
