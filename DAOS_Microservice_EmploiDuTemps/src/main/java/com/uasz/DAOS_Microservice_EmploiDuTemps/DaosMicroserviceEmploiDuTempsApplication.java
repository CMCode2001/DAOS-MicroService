package com.uasz.DAOS_Microservice_EmploiDuTemps;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.uasz.DAOS_Microservice_EmploiDuTemps.Repartition_Service.Interface.RepartitionProxy;
import com.uasz.DAOS_Microservice_EmploiDuTemps.models.Repartition;
import com.uasz.DAOS_Microservice_EmploiDuTemps.services.RepartitionService;


@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class DaosMicroserviceEmploiDuTempsApplication implements CommandLineRunner{

	private final RepartitionProxy repartitionProxy;

	@Autowired
	private RepartitionService repartitionService;

	public DaosMicroserviceEmploiDuTempsApplication(RepartitionProxy repartitionProxy){
		this.repartitionProxy = repartitionProxy;
	}

	public static void main(String[] args) {
		SpringApplication.run(DaosMicroserviceEmploiDuTempsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Le microservice [ Emploi du Temps ] a été démarrée avec succès !");

		System.out.println(repartitionProxy.lister_Repartitions());
		List<Repartition> repartitions = repartitionProxy.lister_Repartitions();

		for(int i=0 ; i<repartitions.size() ; i++){
			repartitionService.ajouter_Repartition(repartitions.get(i));
		}
		
	}

}
