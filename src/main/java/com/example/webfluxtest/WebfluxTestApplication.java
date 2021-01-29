package com.example.webfluxtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// @EnableR2dbcRepositories(basePackages = "com.example.webfluxtest.employee.reactive")
// @EnableJpaRepositories(basePackages = "com.example.webfluxtest.employee.dao")
public class WebfluxTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebfluxTestApplication.class, args);
	}

}
