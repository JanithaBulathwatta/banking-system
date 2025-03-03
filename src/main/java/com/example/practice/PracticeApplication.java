package com.example.practice;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Bank Application",
				description = "Back-end API",
				version = "v1.0",
				contact = @Contact(
						name = "janitha bulathwatta",
						email = "janithabulathwatta04@gmail.com",
						url = "https://github.com/JanithaBulathwatta/mini-banking-app"
				),
				license = @License(
						name = "Bank Application",
						url = "https://github.com/JanithaBulathwatta/mini-banking-app"
				)

		),
		externalDocs = @ExternalDocumentation(
				description = "Bank App",
				url = "https://github.com/JanithaBulathwatta/mini-banking-app"
		)

)
public class PracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(PracticeApplication.class, args);
	}

}
