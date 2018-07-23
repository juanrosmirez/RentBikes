package com.project.service.impl;

import org.joda.time.DateTime;
import org.joda.time.Weeks;

import com.project.entities.Customer;
import com.project.service.Rent;

public class RentPerWeek extends Rent {

	public RentPerWeek(DateTime startDate, DateTime endDate,float planPrice, Customer customer){
		this.price = 0;
		this.startDate = startDate;
		this.endDate = endDate;
		this.planPrice = planPrice;
		this.customer = customer;
		calculatePrice();
	}

	@Override
	protected void calculatePrice() {
		this.price = Weeks.weeksBetween(this.getStartDate(), this.getEndDate()).getWeeks() * this.planPrice;
	}
}
