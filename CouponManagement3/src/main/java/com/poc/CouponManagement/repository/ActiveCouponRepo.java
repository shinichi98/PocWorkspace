package com.poc.CouponManagement.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.poc.CouponManagement.DataModel.Coupon;

@Repository
public interface ActiveCouponRepo extends MongoRepository<Coupon, Integer>{
	

}
