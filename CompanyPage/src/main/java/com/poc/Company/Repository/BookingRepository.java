package com.poc.Company.Repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.poc.Company.model.Company;
import com.poc.Company.model.Coupon;

public interface BookingRepository extends MongoRepository<Company, String>{
	
	@Query(value = "{id:?0}")
	public Company findcompanyById(String id);
	
	@Query(value = "{username:?0}")
	public List<Company> findBookingByUserName(String userName);

}
