package com.poc.CustomerManagement.Controllers;

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
import org.springframework.web.client.RestTemplate;

import com.poc.CustomerManagement.DataModel.Coupon;
import com.poc.CustomerManagement.DataModel.Customer;
import com.poc.CustomerManagement.repository.CustomerRepo;
import com.poc.CustomerManagement.repository.CustomUpdateRepository;

@RestController
@RequestMapping("/customer")
public class CustomerDaoController {
	
//	@GetMapping("/home")
//	public String hello() {
//		return "how are you all";
//	}
	//injecting the data
	
	@Autowired
	CustomerRepo repository;
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
    CustomUpdateRepository customRepo;
	@GetMapping("/")
	public String home() {
		return "welcome to your customer page!!!";
	}
	//now we will create and add coupon function with postmapping
	@PostMapping("/AddCustomer")
	public ResponseEntity<?> AddCustomer(@RequestBody Customer customer) {
		repository.save(customer);
		return new ResponseEntity<>("Added New coupon"+customer.getId(), HttpStatus.OK);	
	}
	
	@GetMapping("/findAllCustomers")
	public List<Customer> getCustomers(){
		return repository.findAll();
	}
	
	@DeleteMapping("/deleteCustomer/{id}")
	public ResponseEntity<?> delCustomer(@PathVariable String id) {
		repository.deleteById(id);
		return new ResponseEntity<>("Added New coupon "+id, HttpStatus.OK);	
	}
	@PostMapping("/bookCoupon/{id}")
	public ResponseEntity<?> bookCoupon(@RequestBody Coupon coupon,@PathVariable String id) {
		String s=restTemplate.postForObject("http://localhost:8084/book/bookCoupon",coupon,String.class);
		repository.findCustomerById(id).append(coupon);
		return new ResponseEntity<>("Added New coupon "+coupon.getId() + "with customer "+ id, HttpStatus.OK);	
	}
	
}
	
//	
//	@GetMapping("/findAllCoupons/{id}")
//	public Optional<Customer> getCoupon(@PathVariable int id){
//		return repository.findById(id);
//	}
//	
//	@DeleteMapping("/deleteCoupon/{id}")
//	public ResponseEntity<?> deleteCoupon(@PathVariable int id){
//		repository.deleteById(id);
//		return new ResponseEntity<>("Deleted a coupon with id : "+ id, HttpStatus.OK);
//	}
//	
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
//}
