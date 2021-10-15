package com.poc.bookingCoupon.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poc.bookingCoupon.Repository.BookingRepository;

import com.poc.bookingCoupon.model.Coupon;

@Service
public class BookingService {

	@Autowired
	private BookingRepository bookingRepository;
	
	public String bookCoupon(Coupon coupon) {

		//bookingDetails.setId(UUID.randomUUID().toString());
		coupon.setStatus("Confirmed");
		//coupon.setPrice(0.00);
		//String uniqueID = UUID.randomUUID().toString();

		bookingRepository.save(coupon);
		return "Coupon booked with Id  " + coupon.getId();
	}
	public Coupon getCoupon(String id) {
		return bookingRepository.findCouponById(id);
	}

	public String CouponStatus(String id) {
		Coupon s=bookingRepository.findCouponById(id);
		return s.getStatus();
	}

	public List<Coupon> showBookedCoupons(String userName) {
		return bookingRepository.findstatus(userName);
	}

}
