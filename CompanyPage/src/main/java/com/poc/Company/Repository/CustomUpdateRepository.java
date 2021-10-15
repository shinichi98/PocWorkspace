package com.poc.Company.Repository;

import java.util.List;

import com.poc.Company.model.Coupon;

public interface CustomUpdateRepository {
	void updateList(String id,List<Coupon>c);
//	void updateDescription(int id,String  cdescription);
//	void updatePercentage(int id,int percentage);
}
