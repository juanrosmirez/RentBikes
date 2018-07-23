package com.project.entities;

public class Invoice {

	private Customer customer;
	
	private float price;
	
	public Customer getCustomer() {
		return customer;
	}


	public float getPrice() {
		return price;
	}

	public Invoice(Customer customer, float price) {
		super();
		this.customer = customer;
		this.price = price;
	}
}
