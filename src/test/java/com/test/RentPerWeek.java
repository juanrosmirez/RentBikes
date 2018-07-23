package com.test;

import static org.junit.Assert.*;

import org.joda.time.DateTime;
import org.junit.Test;

import com.project.entities.Customer;
import com.project.entities.Invoice;
import com.project.factory.RentFactory;
import com.project.service.Rent;
import com.project.utils.Constants;

public class RentPerWeek {

	@Test
	public void validRent() {
		Customer customer = new Customer("Juan","Rosmirez",12345678,18);
		
		Rent r = RentFactory.getRent(Constants.RENTA_PER_WEEK,new DateTime("2010-06-14T13:30:00"),new DateTime("2010-06-28T13:30:00"),customer);
		
		Invoice invoice = r.getInvoice();
		
		assertEquals(120, invoice.getPrice(), 0.0f);
	}

}
