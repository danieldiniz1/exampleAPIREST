package br.com.training.exampleAPIREST;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class ExampleApirestApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExampleApirestApplication.class, args);
	}

}
