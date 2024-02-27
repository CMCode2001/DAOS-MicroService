package com.uasz.DAOS_Microservice_Register;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class DaosMicroserviceRegisterApplication {

	public static void main(String[] args) {
		SpringApplication.run(DaosMicroserviceRegisterApplication.class, args);
	}

}
