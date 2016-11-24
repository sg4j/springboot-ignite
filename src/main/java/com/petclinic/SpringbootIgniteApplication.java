package com.petclinic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

@SpringBootApplication
@EnableCaching
@EnableCircuitBreaker
public class SpringbootIgniteApplication {

	public static void main(String[] args) {
		
		System.out.println("Port is "+args[0]);
		System.setProperty("server.port", args[0]);
		SpringApplication.run(SpringbootIgniteApplication.class, args);
	}
}
