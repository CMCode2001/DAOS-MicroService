package com.uasz.DAOS_Microservice_Repartition.Maquette_Service.Controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.uasz.DAOS_Microservice_Repartition.Maquette_Service.Interface.UEProxy;
import com.uasz.DAOS_Microservice_Repartition.Maquette_Service.Model.UE;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * UEController
 */
@Controller
@AllArgsConstructor
public class UEController {

    private final UEProxy ueProxy;

    @RequestMapping(value = "/repartition/afficher_ue", method=RequestMethod.GET)
    public String lister_ue(Model model) {
      List<UE> ueList=ueProxy.lister_ue();
      model.addAttribute("listeDesUE", ueList);
      return "afficher_ue";
    }
    
    
}