package com.poc.CouponManagement.DataModel;

import java.util.Collection;

import org.springframework.stereotype.Component;

@Component
public class Company {
	private int id;
	private String name;
	private String password;
	private String email;

//	Sprivate Collection<Coupon> coupons;

//    private Collection<Income> incomes;

    public Company() {
    }



    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Company)) {
            return false;
        }
        Company other = (Company) obj;
        return this.id == other.id;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

//	public Collection<Coupon> getCoupons() {
//		return coupons;
//	}
//
//	public void setCoupons(Collection<Coupon> coupons) {
//		this.coupons = coupons;
//	}
//
//	public Collection<Income> getIncomes() {
//		return incomes;
//	}
//
//	public void setIncomes(Collection<Income> incomes) {
//		this.incomes = incomes;
//	}
//
//	@Override
//	public String toString() {
//		return "Company [id=" + id + ", name=" + name + ", password=" + password + ", email=" + email + ", coupons="
//				+ coupons + ", incomes=" + incomes + "]";
//	}

    
}
