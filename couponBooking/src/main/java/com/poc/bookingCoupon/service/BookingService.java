package com.poc.bookingCoupon.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poc.bookingCoupon.Repository.BookingRepository;

import com.poc.bookingCoupon.model.Coupon;

@Service
public class BookingService {

	@Autowired
	private BookingRepository bookingRepository;
	
	public String bookCoupon(Coupon bookingDetails) {

		bookingDetails.setId(UUID.randomUUID().toString());
		bookingDetails.setStatus("Confirmed");
		bookingDetails.setPrice(0.00);
		//String uniqueID = UUID.randomUUID().toString();

		bookingRepository.save(bookingDetails);
		return "Ticket booked successfully, your PNR number is " + bookingDetails.getId();
	}

	public String CouponStatus(Coupon coupon) {
		Coupon s=bookingRepository.findBookingById(coupon.getId());
		return s.getStatus();
	}

	public List<Coupon> showBookedCoupons(String userName) {
		return bookingRepository.findBookingByUserName(userName);
	}

}
