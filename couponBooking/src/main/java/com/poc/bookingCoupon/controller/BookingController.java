package com.poc.bookingCoupon.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.poc.bookingCoupon.model.Coupon;
import com.poc.bookingCoupon.service.BookingService;

@RestController
@RequestMapping("/book")
public class BookingController {

	@Autowired
	private BookingService bookingService;
	
	@GetMapping("/")
	public String hello() {
		return "hello welcome";
	}
	@GetMapping("/getCoupon/{id}")
	public Coupon getCoupon(@PathVariable String id) {
		return bookingService.getCoupon(id);
	}
	

	@PostMapping("/bookCoupon")
	public String bookTicket(@RequestBody Coupon bookingDetails) {
		return bookingService.bookCoupon(bookingDetails);
	}

	@GetMapping("/checkIdStatus/{id}")
	public String checkIdStatus(@PathVariable String id) {
		return bookingService.CouponStatus(id);
	}

	@GetMapping("/showstatus/{userName}")
	public List<Coupon> showBookedCoupons(@PathVariable String userName) {
		return bookingService.showBookedCoupons(userName);
	}
}
