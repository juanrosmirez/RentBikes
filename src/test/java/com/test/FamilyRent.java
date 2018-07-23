package com.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.junit.Test;

import com.project.entities.Customer;
import com.project.entities.Invoice;
import com.project.exceptions.InvalidAmountOfRentsException;
import com.project.factory.RentFactory;
import com.project.service.Rent;
import com.project.utils.Constants;

public class FamilyRent {
	@Test
	public void threeDifferentsRents(){
		
		Customer customer = new Customer("Juan","Rosmirez",12345678,18);
		
		Rent r1 = RentFactory.getRent(Constants.RENTA_PER_DAY,new DateTime("2010-06-14T13:30:00"),new DateTime("2010-06-15T13:30:00"),customer);
		Rent r2 = RentFactory.getRent(Constants.RENTA_PER_HOUR,new DateTime("2010-06-14T13:30:00"),new DateTime("2010-06-14T14:30:00"),customer);
		Rent r3 = RentFactory.getRent(Constants.RENTA_PER_WEEK,new DateTime("2010-06-14T13:30:00"),new DateTime("2010-06-21T13:30:00"),customer);
				
		List<Rent> rent =  new ArrayList<Rent>();
		
		rent.add(r1);
		rent.add(r2);
		rent.add(r3);
		
		Rent familyRent = null;
		try {
			familyRent = RentFactory.getRent(Constants.FAMILY_RENT,rent,customer);
		} catch (InvalidAmountOfRentsException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Invoice invoice = familyRent.getInvoice();
		
		assertEquals(59.5, invoice.getPrice(),0.0f);	
		
	}
	@Test
	public void invalidAmountOfRents() {
		
		Customer customer = new Customer("Juan","Rosmirez",12345678,18);
		
		Rent r1 = RentFactory.getRent(Constants.RENTA_PER_DAY,new DateTime("2010-06-14T13:30:00"),new DateTime("2010-06-15T13:30:00"),customer);
		Rent r2 = RentFactory.getRent(Constants.RENTA_PER_HOUR,new DateTime("2010-06-14T13:30:00"),new DateTime("2010-06-14T14:30:00"),customer);
				
		List<Rent> rent =  new ArrayList<Rent>();
		
		rent.add(r1);
		rent.add(r2);
		
		Rent familyRent = null;
		try {
			familyRent = RentFactory.getRent(Constants.FAMILY_RENT,rent,customer);
		} catch (InvalidAmountOfRentsException e) {
			assertEquals(null,familyRent);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void fiveEqualsRents() {
		Customer customer = new Customer("Juan","Rosmirez",12345678,18);
		
		Rent r1 = RentFactory.getRent(Constants.RENTA_PER_DAY,new DateTime("2010-06-14T13:30:00"),new DateTime("2010-06-15T13:30:00"),customer);
		Rent r2 = RentFactory.getRent(Constants.RENTA_PER_DAY,new DateTime("2010-06-14T13:30:00"),new DateTime("2010-06-15T13:30:00"),customer);
		Rent r3 = RentFactory.getRent(Constants.RENTA_PER_DAY,new DateTime("2010-06-14T13:30:00"),new DateTime("2010-06-15T13:30:00"),customer);
		Rent r4 = RentFactory.getRent(Constants.RENTA_PER_DAY,new DateTime("2010-06-14T13:30:00"),new DateTime("2010-06-15T13:30:00"),customer);
		Rent r5 = RentFactory.getRent(Constants.RENTA_PER_DAY,new DateTime("2010-06-14T13:30:00"),new DateTime("2010-06-15T13:30:00"),customer);
				
		List<Rent> rent =  new ArrayList<Rent>();
		
		rent.add(r1);
		rent.add(r2);
		rent.add(r3);
		rent.add(r4);
		rent.add(r5);
		
		Rent familyRent = null;
		try {
			familyRent = RentFactory.getRent(Constants.FAMILY_RENT,rent,customer);
		} catch (InvalidAmountOfRentsException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Invoice invoice = familyRent.getInvoice();
		
		assertEquals(70, invoice.getPrice(),0.0f);
	}
}
