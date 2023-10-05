package com.springboot.practice;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Spring Boot REST API Documentation",
				description = "Spring BOOT REST API Documentation",
				version = "v1.0",
				contact = @Contact(
						name = "Ajay",
						email = "ajay@gmail.com",
						url = "https://abc.com"
				),
				license = @License(
						name = "Apache 2.0",
						url = "https://www.abc.com"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "Spring boot user management documentation",
				url = "https://abc.com"
		)
)
public class SpringBootPracticeApplication {

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootPracticeApplication.class, args);
	}

}
