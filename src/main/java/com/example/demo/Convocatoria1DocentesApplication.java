package com.example.demo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@EntityScan(basePackages = {"com.example.demo.models"} )
public class Convocatoria1DocentesApplication {

	public static void main(String[] args) {
		SpringApplication.run(Convocatoria1DocentesApplication.class, args);
	}

}
