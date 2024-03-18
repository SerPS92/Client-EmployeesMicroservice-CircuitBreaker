package com.example.ClientEmployeesMicroserviceCircuitBreaker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.SpringVersion;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ClientEmployeesMicroserviceCircuitBreakerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientEmployeesMicroserviceCircuitBreakerApplication.class, args);
		System.out.println(SpringVersion.getVersion());
	}

	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}

}
