package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@Configuration
@EntityScan(basePackages = {"com.example.demo.models"})
public class TutoriaAplication {

    public static void main(String[] args) {
        SpringApplication.run(TutoriaAplication.class, args);
    }
}