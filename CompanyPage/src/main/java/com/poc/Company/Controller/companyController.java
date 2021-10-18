package com.poc.Company.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.poc.Company.model.Company;
import com.poc.Company.model.Coupon;
import com.poc.Company.service.companyService;

@RestController
@RequestMapping("/company")
public class companyController {

	@Autowired
	private companyService bookingService;
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/")
	public String hello() {
		return "hello welcome";
	}
	@PostMapping("/AddCompany")
	public ResponseEntity<?> AddCompany(@RequestBody Company company) {
		bookingService.addCompany(company);
		return new ResponseEntity<>("Added New company"+company.getId(),HttpStatus.OK);	
	}
	@PostMapping("/AddCoupon/{id}")
	public String addCoupon(@RequestBody Coupon coupon,@PathVariable String id) {
		bookingService.appendcoupon(coupon, id);
		return restTemplate.postForObject("http://localhost:8086/coupon/AddCoupon",coupon,String.class);
		
		//return result;
	}
	@DeleteMapping("/deleteCompany/{id}")
	public void deleteCoupon(@PathVariable String id) {
		bookingService.deleteCompany(id);
		//return new ResponseEntity<>("deleted company with id "+id,HttpStatus.OK);
	}
//	@PostMapping("/AddCoupon2/{id}")
//	public ResponseEntity<?> addCoupon2(@RequestBody Coupon coupon,@PathVariable String id) {
//		bookingService.appendcoupon(coupon, id);
//		return new ResponseEntity<>("Added New coupon"+coupon.getId(),HttpStatus.OK);
//	}
	@GetMapping("/companyCoupons/{id}")
	public List<Coupon> createdCoupons(@PathVariable String id) {
		return bookingService.totalCoupons(id);
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
