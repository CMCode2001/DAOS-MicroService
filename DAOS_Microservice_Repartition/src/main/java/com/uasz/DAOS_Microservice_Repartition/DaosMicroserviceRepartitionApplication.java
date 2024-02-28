package com.uasz.DAOS_Microservice_Repartition;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.uasz.DAOS_Microservice_Repartition.Maquette_Service.Interface.UEProxy;

@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class DaosMicroserviceRepartitionApplication  implements CommandLineRunner{
	

	public DaosMicroserviceRepartitionApplication(UEProxy ueProxy){
		this.ueProxy = ueProxy;
	}
	public static void main(String[] args) {
		SpringApplication.run(DaosMicroserviceRepartitionApplication.class, args);
	}

	private final UEProxy ueProxy;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Le microservice [ Repartition ] a été démarrée avec succès !");

		System.out.println(ueProxy.lister_ue());
	}

}
