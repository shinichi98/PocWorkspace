package com.poc.CustomerManagement.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import com.mongodb.client.result.UpdateResult;
import com.poc.CustomerManagement.DataModel.Customer;

@Component
public class CustomUpdateRepositoryImpl implements CustomUpdateRepository {
	@Autowired
	MongoTemplate mongoTemplate;
	
	public void updateCategory(int id,String category) {
        Query query = new Query(Criteria.where("id").is(id));
        Update update = new Update();
        update.set("category", category);
        
        UpdateResult result = mongoTemplate.updateFirst(query, update, Customer.class);
        
        if(result == null)
            System.out.println("No documents updated");
        else
            System.out.println(result.getModifiedCount() + " document(s) updated..");

    }
	public void updateDescription(int id,String description) {
        Query query = new Query(Criteria.where("id").is(id));
        Update update = new Update();
        update.set("offerDescription", description);
        
        UpdateResult result = mongoTemplate.updateFirst(query, update, Customer.class);
        
        if(result == null)
            System.out.println("No documents updated");
        else
            System.out.println(result.getModifiedCount() + " document(s) updated..");

    }
	public void updatePercentage(int id,int percentage) {
        Query query = new Query(Criteria.where("id").is(id));
        Update update = new Update();
        update.set("offerPercentage", percentage);
        
        UpdateResult result = mongoTemplate.updateFirst(query, update, Customer.class);
        
        if(result == null)
            System.out.println("No documents updated");
        else
            System.out.println(result.getModifiedCount() + " document(s) updated..");

    }

}
