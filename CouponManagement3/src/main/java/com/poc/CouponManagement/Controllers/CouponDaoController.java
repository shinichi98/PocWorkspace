package com.poc.CouponManagement.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poc.CouponManagement.DataModel.Coupon;
import com.poc.CouponManagement.repository.ActiveCouponRepo;
import com.poc.CouponManagement.repository.CustomUpdateRepository;

@RestController
@RequestMapping("/coupon")
public class CouponDaoController {
	
	//injecting the data
	
	@Autowired
	ActiveCouponRepo repository;
	
	@Autowired
    CustomUpdateRepository customRepo;
	

	@GetMapping("/home")
	public String hello() {
		return "how are you all";
	}
	
	//now we will create and add coupon function with postmapping
	@PostMapping("/AddCoupon")
	public String AddCoupon(@RequestBody Coupon coupon) {
		repository.insert(coupon);
		return "coupon added";
		//return new ResponseEntity<>("Added New coupon"+coupon.getId(),HttpStatus.OK);	
	}
	
	@GetMapping("/findAllCoupons")
	public List<Coupon> getCoupons(){
		return repository.findAll();
	}
	
	@GetMapping("/findAllCoupons/{id}")
	public Optional<Coupon> getCoupon(@PathVariable int id){
		return repository.findById(id);
	}
	
	@DeleteMapping("/deleteCoupon/{id}")
	public ResponseEntity<?> deleteCoupon(@PathVariable int id){
		repository.deleteById(id);
		return new ResponseEntity<>("Deleted a coupon with id : "+ id, HttpStatus.OK);
	}
	
//	@PutMapping("/updateCouponCategory/{id}&{value}")
//	public ResponseEntity<?> updateCouponCategory(@PathVariable int id,@PathVariable String value){
//		customRepo.updateCategory(id,value);
//	return new ResponseEntity<>("Updated a coupon with id : "+ id, HttpStatus.OK);
//	}
//	@PutMapping("/updateCouponDescription/{id}&{value}")
//	public ResponseEntity<?> updateCouponDescription(@PathVariable int id,@PathVariable String value){
//		customRepo.updateDescription(id,value);
//	return new ResponseEntity<>("Updated a coupon with id : "+ id, HttpStatus.OK);
//	}
//	@PutMapping("/updateCouponOffer/{id}&{value}")
//	public ResponseEntity<?> updateCouponOffer(@PathVariable int id,@PathVariable int value){
//		customRepo.updatePercentage(id,value);
//	return new ResponseEntity<>("Updated a coupon with id : "+ id, HttpStatus.OK);
//	}
}
