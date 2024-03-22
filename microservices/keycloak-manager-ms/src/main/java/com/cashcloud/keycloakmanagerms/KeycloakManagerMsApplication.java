package com.cashcloud.keycloakmanagerms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class KeycloakManagerMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(KeycloakManagerMsApplication.class, args);
	}

}
