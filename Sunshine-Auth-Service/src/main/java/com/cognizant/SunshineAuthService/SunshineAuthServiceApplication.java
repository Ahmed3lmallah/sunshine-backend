package com.cognizant.SunshineAuthService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@EnableDiscoveryClient
@EnableResourceServer
@EnableAuthorizationServer
@SpringBootApplication
public class SunshineAuthServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SunshineAuthServiceApplication.class, args);
	}

}

