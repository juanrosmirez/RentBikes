package com.project.exceptions;

@SuppressWarnings("serial")
public class InvalidAmountOfRentsException extends Exception{
	public InvalidAmountOfRentsException(String msg){
		super(msg);
	}
}
