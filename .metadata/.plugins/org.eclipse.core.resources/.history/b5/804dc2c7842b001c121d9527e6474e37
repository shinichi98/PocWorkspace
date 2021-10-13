package com.poc.bookingCoupon;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.poc.bookingCoupon.model.Coupon;
import com.poc.bookingCoupon.service.BookingService;

@RestController
public class BookingController {

	@Autowired
	private BookingService bookingService;

	

	@PostMapping("/bookCoupon")
	@ResponseBody
	public String bookTicket(@RequestBody Coupon bookingDetails) {
		return bookingService.bookCoupon(bookingDetails);
	}

	@PostMapping("/checkIdStatus")
	public String checkIdStatus(@RequestBody Coupon onlyPNR) {
		return bookingService.CouponStatus(onlyPNR);
	}

	@GetMapping("/showBookedTickets/{passengerName}")
	public List<Coupon> showBookedCoupons(@PathVariable String userName) {
		return bookingService.showBookedCoupons(userName);
	}
}
