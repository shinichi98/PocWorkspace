package com.poc.bookingCoupon.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.poc.bookingCoupon.Repository.BookingRepository;

import com.poc.bookingCoupon.model.Coupon;
import com.poc.bookingCoupon.model.Payment;
import java.util.Random;

@Service
public class BookingService {

	@Autowired
	private BookingRepository bookingRepository;
	@Autowired
	RestTemplate template;
	public String bookCoupon(Coupon coupon) {
		Payment payment = new Payment();
		payment.setAmount(coupon.getPrice());
		payment.setCouponid(coupon.getId());
		payment.setPaymentId(new Random().nextInt(5000));
		payment=template.postForObject("http://localhost:8085/payment/doPayment", payment, Payment.class);
		coupon.setStatus("Confirmed");
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
//	public String bookCouponbyid(String id) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
