package com.uasz.DAOS_Microservice_Maquette;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class DaosMicroserviceMaquetteApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DaosMicroserviceMaquetteApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Le microservice [ Maquette ] a été démarrée avec succès !");
	}


}
