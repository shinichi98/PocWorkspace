package com.poc.Company;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.poc.Company.model.Company;
import com.poc.Company.model.Coupon;
import com.poc.Company.service.BookingService;

@RestController
public class BookingController {

	@Autowired
	private BookingService bookingService;
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/")
	public String hello() {
		return "hello welcome";
	}
	@PostMapping("/AddCompany/")
	public ResponseEntity<?> AddCoupon(@RequestBody Company coupon) {
		bookingService.addCompany(coupon);
		return new ResponseEntity<>("Added New coupon"+coupon.getId(),HttpStatus.OK);	
	}
	@PostMapping("/AddCoupon/{id}")
	public ResponseEntity<?> addCoupon(@RequestBody Coupon coupon,@PathVariable String id) {
		//ResponseEntity<?> response= 
		restTemplate.postForObject("http://localhost:8086/coupon/AddCoupon",coupon,ResponseEntity.class);
		System.out.println(bookingService.appendcoupon(coupon, id));
		return new ResponseEntity<>("Added New coupon"+coupon.getId(),HttpStatus.OK);
	}
	

//	@PostMapping("/checkIdStatus")
//	public String checkIdStatus(@RequestBody Coupon onlyPNR) {
//		return bookingService.CouponStatus(onlyPNR);
//	}
//
//	@GetMapping("/showBookedTickets/{passengerName}")
//	public List<Coupon> showBookedCoupons(@PathVariable String userName) {
//		return bookingService.showBookedCoupons(userName);
	//}
//	@Autowired
//	private RestTemplate restTemplate;
//	
//	public String bookTicket(BookingModel bookingDetails) {
//		return  restTemplate.postForObject("http://localhost:8082/bookTicket",bookingDetails,String.class);
//	}
//
//	public BookingModel checkPNRstatus(BookingModel bookingDetails) {
//		return restTemplate.postForObject("http://localhost:8082/checkPNR",bookingDetails,BookingModel.class);
//	}
}