package com.uasz.DAOS_Microservice_Repartition;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.uasz.DAOS_Microservice_Repartition.Maquette_Service.Interface.MaquetteProxy;
import com.uasz.DAOS_Microservice_Repartition.models.Enseignement;
import com.uasz.DAOS_Microservice_Repartition.services.EnseignantService;
import com.uasz.DAOS_Microservice_Repartition.services.EnseignementService;


@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class DaosMicroserviceRepartitionApplication  implements CommandLineRunner{

	private final MaquetteProxy maquetteProxy;
	@Autowired
	private EnseignementService enseignementService;

	public DaosMicroserviceRepartitionApplication(MaquetteProxy maquetteProxy){
		this.maquetteProxy = maquetteProxy;
	}
	public static void main(String[] args) {
		SpringApplication.run(DaosMicroserviceRepartitionApplication.class, args);
	}

	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Le microservice [ Repartition ] a été démarrée avec succès !");

		System.out.println(maquetteProxy.lister_Enseignement());
		List<Enseignement> enseignements = maquetteProxy.lister_Enseignement();

		for(int i=0 ; i<enseignements.size() ; i++){
			enseignementService.ajouter_Enseignement(enseignements.get(i));
		}
	}

}
