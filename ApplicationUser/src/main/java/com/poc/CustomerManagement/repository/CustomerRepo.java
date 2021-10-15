package com.poc.CustomerManagement.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;


import com.poc.CustomerManagement.DataModel.Customer;

@Repository
public interface CustomerRepo extends MongoRepository<Customer, String>{
	
	@Query(value = "{id:?0}")
	public Customer findCustomerById(String id);
}
