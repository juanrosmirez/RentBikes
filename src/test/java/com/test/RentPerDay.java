package com.test;

import static org.junit.Assert.*;

import org.joda.time.DateTime;
import org.junit.Test;

import com.project.entities.Customer;
import com.project.entities.Invoice;
import com.project.factory.RentFactory;
import com.project.service.Rent;
import com.project.utils.Constants;

public class RentPerDay {

	@Test
	public void validRent() {
		
		Customer customer = new Customer("Juan","Rosmirez",12345678,18);
		Rent r = RentFactory.getRent(Constants.RENTA_PER_DAY,new DateTime("2010-06-14T13:30:00"),new DateTime("2010-06-20T13:30:00"),customer);
		
		
		Invoice invoice = r.getInvoice();
		
		assertEquals(invoice.getCustomer().getName(),"Juan");
		assertEquals(invoice.getCustomer().getLastName(),"Rosmirez");
		assertEquals(invoice.getCustomer().getDni(),12345678);
		assertEquals(invoice.getCustomer().getAge(),18);
		
		assertEquals(120,invoice.getPrice(),0.0f);
	}
}
