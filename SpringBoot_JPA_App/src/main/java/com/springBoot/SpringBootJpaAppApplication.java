package com.springBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;

// For swagger as it is working for cloud not on local host and also we are 
// using https not http 

@OpenAPIDefinition(
		servers= {
				
				@Server(url = "/", description= "Default Server URL")
		}
	)

@SpringBootApplication
public class SpringBootJpaAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaAppApplication.class, args);
	}

}
