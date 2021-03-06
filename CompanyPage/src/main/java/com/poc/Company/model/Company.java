package com.poc.Company.model;



import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

@Component
@Document(collection="Companies")
public class Company {
	@Id
	private String id;
	private String name;
	private String password;
	private String email;
    private List<Coupon> coupons;
	public Company(String id, String name, String password, String email, List<Coupon> coupons) {
		
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
		this.coupons = coupons;
	}
	public Company() {
    }
	public void append(Coupon coupon) {
		if( this.coupons==null) {
			this.coupons=new ArrayList<Coupon>();
		}
		this.coupons.add(coupon);
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public List<Coupon> getCoupons() {
		return coupons;
	}


	public void setCoupons(List<Coupon> coupons) {
		this.coupons = coupons;
	}



    
}
