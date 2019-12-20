package com.cognizant.SunshineAuthService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@EnableResourceServer
@EnableAuthorizationServer
@SpringBootApplication
public class SunshineAuthServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SunshineAuthServiceApplication.class, args);
	}

}
