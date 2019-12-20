package com.trilogyed.eurekaserviceregistry2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServiceRegistry2Application {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServiceRegistry2Application.class, args);
	}

}
