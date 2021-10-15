package com.poc.CustomerManagement.DataModel;

import java.util.ArrayList;
import java.util.List;

//import java.util.Locale.Category;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//import lombok.ToString;

@Document(collection = "Customers")
public class Customer {
		
		@Id
		private String id;
		private String fullName;
		private String emailid;
		private String password;
		private String preference;		
		private int age;
		private List<Coupon> coupons;
		
		public void append(Coupon coupon) {
			if(coupons==null) {
				coupons=new ArrayList<Coupon>();
			}
			coupons.add(coupon);
		}
		public List<Coupon> getCoupons() {
			return coupons;
		}
		public void setCoupons(List<Coupon> coupons) {
			this.coupons = coupons;
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getFullName() {
			return fullName;
		}
		public void setFullName(String fullName) {
			this.fullName = fullName;
		}
		public String getPreference() {
			return preference;
		}
		public void setPreference(String preference) {
			this.preference = preference;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public String getEmailid() {
			return emailid;
		}
		public void setEmailid(String emailid) {
			this.emailid = emailid;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		
		
		
}
