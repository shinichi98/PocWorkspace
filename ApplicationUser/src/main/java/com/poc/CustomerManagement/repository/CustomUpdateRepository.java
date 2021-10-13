package com.poc.CustomerManagement.repository;

public interface CustomUpdateRepository {
	void updateCategory(int id,String category);
	void updateDescription(int id,String description);
	void updatePercentage(int id,int percentage);
}
