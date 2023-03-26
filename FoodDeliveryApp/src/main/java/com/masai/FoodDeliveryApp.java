package com.masai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(info = @Info(title = "My API", version = "1.0.0", description = "API documentation for My API"))
@SpringBootApplication
public class FoodDeliveryApp {

	public static void main(String[] args) {
		SpringApplication.run(FoodDeliveryApp.class, args);
	}

}
