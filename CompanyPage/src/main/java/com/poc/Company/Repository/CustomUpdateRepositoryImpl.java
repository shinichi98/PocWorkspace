package com.poc.Company.Repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import com.mongodb.client.result.UpdateResult;
import com.poc.Company.model.Company;
import com.poc.Company.model.Coupon;


@Component
public class CustomUpdateRepositoryImpl implements CustomUpdateRepository {
	@Autowired
	MongoTemplate mongoTemplate;
	
	public void updateList(String id,List<Coupon> c) {
        Query query = new Query(Criteria.where("id").is(id));
        Update update = new Update();
        update.set("coupons", c);
        
        UpdateResult result = mongoTemplate.updateFirst(query, update, Company.class);
        
        if(result == null)
            System.out.println("No documents updated");
        else
            System.out.println(result.getModifiedCount() + " document(s) updated..");

    }
//	public void updateDescription(int id,String description) {
//        Query query = new Query(Criteria.where("id").is(id));
//        Update update = new Update();
//        update.set("offerDescription", description);
//        
//        UpdateResult result = mongoTemplate.updateFirst(query, update, Coupon.class);
//        
//        if(result == null)
//            System.out.println("No documents updated");
//        else
//            System.out.println(result.getModifiedCount() + " document(s) updated..");
//
//    }
//	public void updatePercentage(int id,int percentage) {
//        Query query = new Query(Criteria.where("id").is(id));
//        Update update = new Update();
//        update.set("offerPercentage", percentage);
//        
//        UpdateResult result = mongoTemplate.updateFirst(query, update, Coupon.class);
//        
//        if(result == null)
//            System.out.println("No documents updated");
//        else
//            System.out.println(result.getModifiedCount() + " document(s) updated..");
//
//    }


}
