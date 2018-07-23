package com.project.service.impl;

import org.joda.time.DateTime;
import org.joda.time.Hours;

import com.project.entities.Customer;
import com.project.service.Rent;

public class RentPerHour extends Rent {

	public RentPerHour(DateTime startDate, DateTime endDate, float planPrice, Customer customer) {
			this.price = 0;
			this.startDate = startDate;
			this.endDate = endDate;
			this.planPrice = planPrice;
			this.customer = customer;
			calculatePrice();
	}

	@Override
	protected void calculatePrice() {
		this.price = Hours.hoursBetween(this.getStartDate(), this.getEndDate()).getHours() * this.planPrice;
	}
}
