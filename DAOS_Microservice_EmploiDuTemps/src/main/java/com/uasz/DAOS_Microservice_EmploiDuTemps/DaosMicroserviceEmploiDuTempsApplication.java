package com.uasz.DAOS_Microservice_EmploiDuTemps;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class DaosMicroserviceEmploiDuTempsApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(DaosMicroserviceEmploiDuTempsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Le microservice [ Emploi du Temps ] a été démarrée avec succès !");
		
	}

}
