package com.mihir.model;

// model object for slot
public class Slot {
	private Car parkedCar;
	private Integer slotNumber;
	
	public Slot(final Integer slotNumber) {
		// TODO Auto-generated constructor stub
		this.slotNumber=slotNumber;
	}
	
	public Car getParkedCar() {
		return parkedCar;
	}
	public Integer getSlotNumber() {
		return slotNumber;
	}
	
	public void assignCar(Car car) {
		this.parkedCar=car;
	}
	
	public void unassignCar() {
		this.parkedCar=null;
	}

	public boolean isSlotFree() {
		// TODO Auto-generated method stub
		return parkedCar == null;
	}
}
