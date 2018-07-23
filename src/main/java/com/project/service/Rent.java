package com.project.service;

import org.joda.time.DateTime;

import com.project.entities.Customer;
import com.project.entities.Invoice;



public abstract class Rent {
	
	protected Customer customer;
	
	protected float planPrice;

    protected float price;
 
	protected DateTime startDate;
    
    protected DateTime endDate;
    
    public Customer getCustomer() {
		return customer;
	}

    public float getPrice() {
  		return price;
  	}
    public DateTime getStartDate() {
		return startDate;
	}

	public DateTime getEndDate() {
		return endDate;
	}
	
	public Invoice getInvoice() {
		return new Invoice(this.customer, this.price);
	}

    protected abstract void calculatePrice();
    
}

