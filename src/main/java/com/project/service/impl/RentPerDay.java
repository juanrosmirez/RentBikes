package com.project.service.impl;

import org.joda.time.DateTime;
import org.joda.time.Days;

import com.project.entities.Customer;
import com.project.service.Rent;

public class RentPerDay extends Rent{
	
	
	public RentPerDay(DateTime startDate, DateTime endDate,float planPrice, Customer customer){
		this.price = 0;
		this.startDate = startDate;
		this.endDate = endDate;
		this.planPrice = planPrice;
		this.customer = customer;
		calculatePrice();
	}
	

	@Override
	protected void calculatePrice() {
		this.price = Days.daysBetween(this.getStartDate(), this.getEndDate()).getDays() * this.planPrice;
	}
}
