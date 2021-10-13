package com.poc.CustomerManagement;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class CustomerManagementApplication {
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(CustomerManagementApplication.class, args);
	}

}
