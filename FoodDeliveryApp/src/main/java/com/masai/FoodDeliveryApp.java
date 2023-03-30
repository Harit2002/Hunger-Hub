package com.masai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;

@OpenAPIDefinition
@SpringBootApplication
public class FoodDeliveryApp {

	public static void main(String[] args) {
		SpringApplication.run(FoodDeliveryApp.class, args);
	}

	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
				.components(new Components().addSecuritySchemes("bearer-key",
						new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT")))
				.info(new Info().title("HungerHub API").version("1.0").description(
						"This is food delivery app REST API using spring boot. We have used sping data jpa i.e ORM for data operations and spring-security using JWT for user validation / authentication.")
						.termsOfService("8888/swagger-ui/index.html").license(new License().name("Apache 2.0")));
	}

}
