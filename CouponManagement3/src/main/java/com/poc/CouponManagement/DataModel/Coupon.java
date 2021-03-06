package com.poc.CouponManagement.DataModel;

//import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

//import java.util.Locale.Category;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import com.poc.CouponManagement.enums.CouponType;




//import lombok.ToString;


@Component
@Document(collection = "ActiveCoupon")
public class Coupon  {

    @Id
	private String id;
    private String title;
    private Date startDate;
    private Date endDate;
    private int offeredDiscount;
    private String status="NotConfirmed";
//  private CouponType couponType;    
    private String message;
    private double price;
    public int getOfferedDiscount() {
		return offeredDiscount;
	}

	public void setOfferedDiscount(int offeredDiscount) {
		this.offeredDiscount = offeredDiscount;
	}


	
    
    public Coupon() {
    }
  
    

	

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getAmount() {
        return offeredDiscount;
    }

    public void setAmount(int amount) {
        this.offeredDiscount = amount;
    }

    

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }





	public String getStatus() {
		return status;
	}





	public void setStatus(String status) {
		this.status = status;
	}

   
    }

//    @Override
//    public String toString() {
//        return "Coupon{" +
//                "id=" + id +
//                ", title='" + title + '\'' +
//                ", startDate=" + startDate +
//                ", endDate=" + endDate +
//                ", amount=" + amount +
//                ", couponType=" + couponType +
//                ", message='" + message + '\'' +
//                ", price=" + price +
//                ", companyId=" + company.getId() +
//                '}';
//    }

