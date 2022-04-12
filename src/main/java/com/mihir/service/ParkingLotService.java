package com.mihir.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.mihir.exception.ParkingLotException;
import com.mihir.model.Car;
import com.mihir.model.ParkingLot;
import com.mihir.model.Slot;
import com.mihir.model.parking.strategy.ParkingStrategy;

/* 
 service for enabling the functioning of a parking lot. this will have all the business logic
 of how the parking service will operate
*/

public class ParkingLotService {
	private ParkingLot parkingLot;
	private ParkingStrategy parkingStrategy;
	
	public void createParkingLot(final ParkingLot parkingLot, final ParkingStrategy parkingStrategy) {
	    if (this.parkingLot != null) {
	      throw new ParkingLotException("Parking lot already exists.");
	    }
	    this.parkingLot = parkingLot;
	    this.parkingStrategy = parkingStrategy;
	    for (int i = 1; i <= parkingLot.getCapacity(); i++) {
	      parkingStrategy.addSlot(i);
	    }
	  }
	
	public Integer park(final Car car) {
	    validateParkingLotExists();
	    final Integer nextFreeSlot = parkingStrategy.getNextSlot();
	    parkingLot.park(car, nextFreeSlot);
	    parkingStrategy.removeSlot(nextFreeSlot);
	    return nextFreeSlot;
	  }
	
	/**
	   * Helper method to validate whether the parking lot exists or not. This is used to validate the
	   * existence of parking lot before doing any operation on it.
	   */
	  private void validateParkingLotExists() {
	    if (parkingLot == null) {
	      throw new ParkingLotException("Parking lot does not exists to park.");
	    }
	  }
	  
	  /**
	   * Unparks a car from a slot. Freed slot number is given back to the parking strategy so that it
	   * becomes available for future parkings.
	   *
	   * @param slotNumber Slot number to be freed.
	   */
	  public void makeSlotFree(final Integer slotNumber) {
	    validateParkingLotExists();
	    parkingLot.makeSlotFree(slotNumber);
	    parkingStrategy.addSlot(slotNumber);
	  }
	  
	  /**
	   * Gets the list of all the slots which are occupied.
	   */
	  public List<Slot> getOccupiedSlots() {
		  validateParkingLotExists();
		  final List<Slot> occupiedSlotsList = new ArrayList<>();
		  final Map<Integer,Slot> allSlots = parkingLot.getSlots();
		  
		  for(int i=1;i<=parkingLot.getCapacity();i++) {
			  if(allSlots.containsKey(i)) {
				  final Slot slot=allSlots.get(i);
				  if(!slot.isSlotFree()) {
					occupiedSlotsList.add(slot);  
				  }
			  }
		  }
		  return occupiedSlotsList;
	  }
	  
	  /**
	   * Gets all the slots in which a car with given color is parked.
	   *
	   * @param color Color to be searched.
	   * @return All matching slots.
	   */
	  public List<Slot> getSlotsForColor(final String color) {
		  final List<Slot> occupiedSlots = getOccupiedSlots();
		  return occupiedSlots.stream()
				  .filter(slot->slot.getParkedCar().getColor().equals(color))
				  .collect(Collectors.toList());
	  }
	
}
