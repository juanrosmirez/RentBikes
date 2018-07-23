package com.project.entities;

public class Customer {
	
	private String name;
	
	private String lastName;
	
	private int dni;
	
	private int age;
	
	public String getName() {
		return name;
	}

	public String getLastName() {
		return lastName;
	}

	public int getDni() {
		return dni;
	}

	public int getAge() {
		return age;
	}

	public Customer(String name, String lastName, int dni, int age) {
		this.name = name;
		this.lastName = lastName;
		this.dni = dni;
		this.age = age;
	}
}
