package com.poc.Company;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableMongoRepositories
public class BookingServiceApplication {
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();}
	public static void main(String[] args) {
		SpringApplication.run(BookingServiceApplication.class, args);
	}

}