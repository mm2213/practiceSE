package com.mihir.model.parking.strategy;

// for deciding how cars are to be parked in parking lot
public interface ParkingStrategy {
	
	public void addSlot(Integer slotNumber);
	
	public void removeSlot(Integer slotNumber);
	
	public Integer getNextSlot();
}
