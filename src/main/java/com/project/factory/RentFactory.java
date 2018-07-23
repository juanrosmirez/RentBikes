package com.project.factory;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.joda.time.DateTime;

import com.project.entities.Customer;
import com.project.service.Rent;
import com.project.service.impl.FamilyRent;
import com.project.service.impl.RentPerDay;
import com.project.service.impl.RentPerHour;
import com.project.service.impl.RentPerWeek;
import com.project.utils.Constants;


public class RentFactory {
	
	private static HashMap<String, Float> price;
	
	static {
		Properties p = new Properties();
		try {
			p.load(new FileReader("src/main/resources/rent.properties"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}


		price = new HashMap<String, Float>();
		
		price.put(Constants.RENTA_PER_DAY,Float.valueOf(p.getProperty("rentperdayprice")));
		price.put(Constants.RENTA_PER_HOUR,Float.valueOf(p.getProperty("rentperhourprice")));
		price.put(Constants.RENTA_PER_WEEK,Float.valueOf(p.getProperty("rentperweekprice")));
		price.put(Constants.FAMILY_RENT,Float.valueOf(p.getProperty("familypromotion")));
	}

	public static Rent getRent(String rentType,List<Rent> rent, Customer customer) throws Exception {
		if(rentType.equals(Constants.FAMILY_RENT))
			return new FamilyRent(price.get(Constants.FAMILY_RENT),rent,customer);
		return null;
	}
	public static Rent getRent(String rentType, DateTime startDate, DateTime endDate, Customer customer) {
		 if (rentType.equals(Constants.RENTA_PER_DAY))
			 return new RentPerDay(startDate, endDate, price.get(Constants.RENTA_PER_DAY),customer);
		 else if(rentType.equals(Constants.RENTA_PER_HOUR))
			 return new RentPerHour(startDate, endDate, price.get(Constants.RENTA_PER_HOUR),customer);
		 else if(rentType.equals(Constants.RENTA_PER_WEEK))
			 return new RentPerWeek(startDate, endDate, price.get(Constants.RENTA_PER_WEEK),customer); 
		return null;
	}
}
