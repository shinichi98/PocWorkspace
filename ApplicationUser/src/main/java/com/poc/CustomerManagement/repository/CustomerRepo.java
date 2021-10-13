package com.poc.CustomerManagement.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.poc.CustomerManagement.DataModel.Customer;

@Repository
public interface CustomerRepo extends MongoRepository<Customer, Integer>{
	

}
