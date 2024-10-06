package com.mid.maliha.nutritionmicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class NutritionMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(NutritionMicroserviceApplication.class, args);
	}

}
