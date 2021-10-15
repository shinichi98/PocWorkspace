package com.poc.bookingCoupon.Repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;


import com.poc.bookingCoupon.model.Coupon;

public interface BookingRepository extends MongoRepository<Coupon, String>{
	
	@Query(value = "{id:?0}")
	public Coupon findCouponById(String id);
	
	@Query(value = "{status:?0}")
	public List<Coupon> findstatus(String status);

}
