package com.mihir.model;

// model object for a car
public class Car {
	private String registrationNumber;
	private String color;
	
	public String getRegistrationNumber() {
		return registrationNumber;
	}
	
	public String getColor() {
		return color;
	}
	
	public Car(final String registrationNumber, final String color) {
		// TODO Auto-generated constructor stub
		this.registrationNumber=registrationNumber;
		this.color=color;
	}
}
