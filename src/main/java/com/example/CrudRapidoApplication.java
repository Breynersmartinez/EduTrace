package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrudRapidoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudRapidoApplication.class, args);
		System.out.println(" This API developed in Spring Boot allows the management of students, projects, teams, and tasks. Its purpose is to provide traceability of teamwork, ensuring that each member has evidence of their progress and responsibilities.");
	}

}
