package com.poc.Company.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poc.Company.Repository.BookingRepository;
import com.poc.Company.model.Company;
import com.poc.Company.model.Coupon;
import com.poc.Company.Repository.*;

@Service
public class companyService {

	@Autowired
	private BookingRepository bookingRepository;
	@Autowired
    CustomUpdateRepository customRepo;
	
	public void appendcoupon(Coupon coupon,String id) {
		Company c=bookingRepository.findcompanyById(id);
		c.append(coupon);
		bookingRepository.deleteById(id);
		bookingRepository.save(c);
	}
	public String addCompany(Company company) {

		bookingRepository.save(company);
		return "Company Added " + company.getId();
	}
	public void deleteCompany(String id) {
		bookingRepository.deleteById(id);
	}
	public List<Coupon> totalCoupons(String id){
		return bookingRepository.findcompanyById(id).getCoupons();
	}
//
//	public String CouponStatus(Coupon coupon) {
//		Coupon s=bookingRepository.findBookingById(coupon.getId());
//		return s.getStatus();
//	}
//
//	public List<Coupon> showBookedCoupons(String userName) {
//		return bookingRepository.findBookingByUserName(userName);
//	}

}
