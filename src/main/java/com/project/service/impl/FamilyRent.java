package com.project.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.project.entities.Customer;
import com.project.exceptions.InvalidAmountOfRentsException;
import com.project.service.Rent;

public class FamilyRent extends Rent {

	public List<Rent> familyList = new ArrayList<Rent>();
	
	public FamilyRent(float planPrice, List<Rent> familyList, Customer customer) throws Exception {
	
		if (familyList.size() >= 3 && familyList.size() <= 5) {
			this.familyList = familyList;
			this.price = 0;
			this.planPrice = planPrice;
			this.customer = customer;
			calculatePrice();
		}
		else
			throw new InvalidAmountOfRentsException("The amount of elements must be between 3 and 5. It was : " + familyList.size()  );
	}
	
	
	protected void calculatePrice() {
		for (Rent rent : familyList) {
			this.price += rent.getPrice();
		}
		this.price = this.price * this.planPrice;
	}
}
